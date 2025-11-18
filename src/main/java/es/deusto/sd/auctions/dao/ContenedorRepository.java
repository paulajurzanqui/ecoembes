package es.deusto.sd.auctions.dao;

import es.deusto.sd.auctions.entity.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Long> {

    // Métodos básicos heredados de JpaRepository (NO los escribes tú):
    // - save(Contenedor)
    // - findById(Long)
    // - findAll()
    // - deleteById(Long)
    // - count()

    // Métodos personalizados usando "Query Methods" (Spring los implementa automáticamente)

    // Buscar por código postal
    List<Contenedor> findByCodigoPostal(Integer codigoPostal);

    // Buscar contenedores con estados en un rango de fechas
    @Query("SELECT DISTINCT c FROM Contenedor c JOIN c.estados e " +
            "WHERE e.fecha BETWEEN :inicio AND :fin")
    List<Contenedor> findContenedoresConEstadosEntreFechas(
            @Param("inicio") LocalDate inicio,
            @Param("fin") LocalDate fin
    );

    // Buscar por ubicación (si lo necesitas)
    Optional<Contenedor> findByDireccion(String direccion);
}
