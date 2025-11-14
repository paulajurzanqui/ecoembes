package es.deusto.sd.auctions.entity;

import java.util.Date;
import java.util.List;

public class Camion {
    List<Long> id_contenedores;
    long id_planta;
    Date fecha;

    public List<Long> getId_contenedores() {
        return id_contenedores;
    }

    public void setId_contenedores(List<Long> id_contenedores) {
        this.id_contenedores = id_contenedores;
    }

    public long getId_planta() {
        return id_planta;
    }

    public void setId_planta(long id_planta) {
        this.id_planta = id_planta;
    }

    public Camion(List<Long> id_contenedores, long id_planta, Date fecha) {
        this.id_contenedores = id_contenedores;
        this.id_planta = id_planta;
        this.fecha = fecha;
    }
}
