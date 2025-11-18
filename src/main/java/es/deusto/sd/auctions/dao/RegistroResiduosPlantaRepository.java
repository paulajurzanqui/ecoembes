package es.deusto.sd.auctions.dao;

import es.deusto.sd.auctions.entity.RegistroResiduosPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RegistroResiduosPlantaRepository {

    // ============================================
    // MÉTODOS AUTOMÁTICOS
    // ============================================

    // Obrtener todo el histórico de una planta
    List<RegistroResiduosPlanta> findByPlantaIdOrderByFechaDesc(Long plantaId);

    // Obtener capacidad de una planta en una fecha específica
    Optional<RegistroResiduosPlanta> findByPlantaIdAndFecha(Long plantaId, LocalDate fecha);

    // Histórico entre fechas
    List<RegistroResiduosPlanta> findByPlantaIdAndFechaBetween(
            Long plantaId,
            LocalDate inicio,
            LocalDate fin
    );

    // ============================================
    // QUERIES PERSONALIZADAS
    // ============================================

    /**
     * Consultar capacidad de una planta para una fecha
     * Requisito: "consultar su capacidad disponible (en toneladas) para un determinado día"
     */
    @Query("SELECT ch.capacidadDisponible FROM CapacidadHistorico ch " +
            "WHERE ch.planta.id = :plantaId AND ch.fecha = :fecha")
    Optional<Double> findCapacidadPorFecha(
            @Param("plantaId") Long plantaId,
            @Param("fecha") LocalDate fecha
    );

    /**
     * Obtener capacidades de todas las plantas para una fecha
     * Útil para mostrar un dashboard
     */
    @Query("SELECT ch FROM CapacidadHistorico ch " +
            "WHERE ch.fecha = :fecha " +
            "ORDER BY ch.planta.nombre ASC")
    List<RegistroResiduosPlanta> findCapacidadesEnFecha(@Param("fecha") LocalDate fecha);

    /**
     * Plantas con capacidad disponible en una fecha específica
     * Combina histórico + requisito de capacidad mínima
     */
    @Query("SELECT ch FROM CapacidadHistorico ch " +
            "WHERE ch.fecha = :fecha " +
            "AND ch.capacidadDisponible >= :cantidadMinima " +
            "AND ch.planta.activa = true " +
            "ORDER BY ch.capacidadDisponible DESC")
    List<RegistroResiduosPlanta> findPlantasConCapacidadEnFecha(
            @Param("fecha") LocalDate fecha,
            @Param("cantidadMinima") Double cantidadMinima
    );

    /**
     * Próximos 10 días de capacidad de una planta
     * Requisito: "Esta información está disponible con 10 días de antelación"
     */
    @Query("SELECT ch FROM CapacidadHistorico ch " +
            "WHERE ch.planta.id = :plantaId " +
            "AND ch.fecha BETWEEN :hoy AND :dentroDeN " +
            "ORDER BY ch.fecha ASC")
    List<RegistroResiduosPlanta> findCapacidadProximos10Dias(
            @Param("plantaId") Long plantaId,
            @Param("hoy") LocalDate hoy,
            @Param("dentroDeN") LocalDate dentroDeN
    );

    /**
     * Estadísticas: Promedio de utilización de una planta
     */
    @Query("SELECT AVG(ch.capacidadUtilizada) FROM CapacidadHistorico ch " +
            "WHERE ch.planta.id = :plantaId " +
            "AND ch.fecha BETWEEN :inicio AND :fin")
    Double calcularPromedioUtilizacion(
            @Param("plantaId") Long plantaId,
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin
    );

    /**
     * Días con mayor ocupación (para análisis de tendencias)
     */
    @Query("SELECT ch FROM CapacidadHistorico ch " +
            "WHERE ch.planta.id = :plantaId " +
            "ORDER BY ch.capacidadUtilizada DESC")
    List<RegistroResiduosPlanta> findDiasMasOcupados(@Param("plantaId") Long plantaId);
}
