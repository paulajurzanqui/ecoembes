package es.deusto.sd.auctions.dao;

import es.deusto.sd.auctions.entity.PlantaDeReciclaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantaDeReciclajeRepository extends JpaRepository<PlantaDeReciclaje, Long> {

    // ============================================
    // MÉTODOS CON "QUERY METHODS" (Automáticos)
    // ============================================

    // Buscar planta por nombre
    Optional<PlantaDeReciclaje> findByNombre(String nombre);

    // Buscar todas las plantas activas
    List<PlantaDeReciclaje> findByActivaTrue();

    // Buscar plantas con capacidad actual mayor a un valor
    List<PlantaDeReciclaje> findByCapacidadActualGreaterThanEqual(Double capacidadMinima);

    // Buscar plantas activas con capacidad suficiente
    List<PlantaDeReciclaje> findByActivaTrueAndCapacidadActualGreaterThanEqual(
            Double capacidadMinima
    );

    // ============================================
    // QUERIES PERSONALIZADAS
    // ============================================

    /**
     * Encuentra plantas que pueden recibir una cantidad específica
     * Requisito: "seleccionar una planta de reciclaje y consultar su capacidad"
     */
    @Query("SELECT p FROM PlantaDeReciclaje p " +
            "WHERE p.activa = true " +
            "AND p.capacidadActual >= :cantidadNecesaria " +
            "ORDER BY p.capacidadActual DESC")
    List<PlantaDeReciclaje> findPlantasConCapacidadDisponible(
            @Param("cantidadNecesaria") Double cantidadNecesaria
    );

    /**
     * Obtener plantas ordenadas por capacidad disponible
     * Útil para asignar a la planta con más espacio primero
     */
    @Query("SELECT p FROM PlantaDeReciclaje p " +
            "WHERE p.activa = true " +
            "ORDER BY p.capacidadActual DESC")
    List<PlantaDeReciclaje> findPlantasActivasOrdenadasPorCapacidad();

    /**
     * Estadísticas: Total de capacidad disponible en el sistema
     */
    @Query("SELECT SUM(p.capacidadActual) FROM PlantaDeReciclaje p " +
            "WHERE p.activa = true")
    Double calcularCapacidadTotalDisponible();

    /**
     * Estadísticas: Total de capacidad máxima del sistema
     */
    @Query("SELECT SUM(p.capacidadTotal) FROM PlantaDeReciclaje p " +
            "WHERE p.activa = true")
    Double calcularCapacidadTotalSistema();

    /**
     * Porcentaje de ocupación del sistema
     */
    @Query("SELECT (SUM(p.capacidadTotal - p.capacidadActual) / SUM(p.capacidadTotal)) * 100 " +
            "FROM PlantaDeReciclaje p WHERE p.activa = true")
    Double calcularPorcentajeOcupacionTotal();
}