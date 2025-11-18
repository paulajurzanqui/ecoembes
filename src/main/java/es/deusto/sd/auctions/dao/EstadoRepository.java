package es.deusto.sd.auctions.dao;
import es.deusto.sd.auctions.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    // ============================================
    // MÉTODOS CON "QUERY METHODS" (Automáticos)
    // ============================================

    // Buscar todos los estados de un contenedor específico
    List<Estado> findByContenedorId(Long contenedorId);

    // Buscar estados de un contenedor ordenados por fecha (más reciente primero)
    List<Estado> findByContenedorIdOrderByFechaDesc(Long contenedorId);

    // Buscar estados por tipo de llenado
    List<Estado> findByLlenado(Estado.tipo llenado);

    // Buscar estados de una fecha específica
    List<Estado> findByFecha(LocalDate fecha);

    // Buscar el estado más reciente de un contenedor
    Optional<Estado> findFirstByContenedorIdOrderByFechaDesc(Long contenedorId);
}