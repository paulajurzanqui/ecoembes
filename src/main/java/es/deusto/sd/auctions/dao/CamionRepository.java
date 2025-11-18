package es.deusto.sd.auctions.dao;

import es.deusto.sd.auctions.entity.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Long> {
    // === CONSULTAS BÁSICAS POR PLANTA ===

    // Buscar todos los envíos a una planta específica
    List<Camion> findByPlantaId(Long plantaId);

    // Buscar envíos a una planta, ordenados por fecha (más recientes primero)
    List<Camion> findByPlantaIdOrderByFechaDesc(Long plantaId);


    // === CONSULTAS POR FECHA ===

    // Buscar envíos en una fecha específica
    List<Camion> findByFecha(Date fecha);

    // Buscar envíos en un rango de fechas
    List<Camion> findByFechaBetween(Date inicio, Date fin);

    // Buscar envíos a una planta en un rango de fechas
    List<Camion> findByPlantaIdAndFechaBetween(
            Long plantaId,
            Date inicio,
            Date fin
    );


    // === CONSULTAS CON JOIN FETCH (para evitar N+1) ===

    // Obtener un camión con su planta cargada (evita lazy loading)
    @Query("SELECT c FROM Camion c JOIN FETCH c.planta WHERE c.id = :id")
    Optional<Camion> findByIdWithPlanta(@Param("id") Long id);

    // Obtener camión con planta Y contenedores
    @Query("SELECT DISTINCT c FROM Camion c " +
            "JOIN FETCH c.planta " +
            "LEFT JOIN FETCH c.contenedores " +
            "WHERE c.id = :id")
    Optional<Camion> findByIdWithRelations(@Param("id") Long id);

    // Buscar por planta con relaciones cargadas
    @Query("SELECT DISTINCT c FROM Camion c " +
            "JOIN FETCH c.planta " +
            "WHERE c.planta.id = :plantaId " +
            "ORDER BY c.fecha DESC")
    List<Camion> findByPlantaIdWithPlanta(@Param("plantaId") Long plantaId);

    // Buscar en rango de fechas con planta cargada
    @Query("SELECT c FROM Camion c " +
            "JOIN FETCH c.planta " +
            "WHERE c.fecha BETWEEN :inicio AND :fin " +
            "ORDER BY c.fecha DESC")
    List<Camion> findByFechaBetweenWithPlanta(
            @Param("inicio") Date inicio,
            @Param("fin") Date fin
    );


    // === CONSULTAS ESPECÍFICAS DE CONTENEDORES ===

    // Buscar todos los camiones que transportaron un contenedor específico
    @Query("SELECT c FROM Camion c JOIN c.contenedores cont WHERE cont.id = :contenedorId")
    List<Camion> findByContenedorId(@Param("contenedorId") Long contenedorId);

    // Contar cuántos envíos se hicieron a una planta
    long countByPlantaId(Long plantaId);

    // Verificar si existe un envío en una fecha específica a una planta
    boolean existsByPlantaIdAndFecha(Long plantaId, Date fecha);

    //Verificar si existe un camión con este id
    boolean existById();
}
