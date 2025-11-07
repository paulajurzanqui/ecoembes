package es.deusto.sd.auctions.dto;

import es.deusto.sd.auctions.entity.Estado;

public class ContenedorDTO {
    long id;
    EstadoDTO ultimo_estado;

    public ContenedorDTO(long id, EstadoDTO ultimo_estado) {
        this.id = id;
        this.ultimo_estado = ultimo_estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EstadoDTO getUltimo_estado() {
        return ultimo_estado;
    }

    public void setUltimo_estado(EstadoDTO ultimo_estado) {
        this.ultimo_estado = ultimo_estado;
    }
}
