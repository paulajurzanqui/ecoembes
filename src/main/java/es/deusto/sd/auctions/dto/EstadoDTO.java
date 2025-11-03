package es.deusto.sd.auctions.dto;

import es.deusto.sd.auctions.entity.Estado;

import java.util.Date;

public class EstadoDTO {
    private String Tipo;
    private Date fecha;

    public EstadoDTO(String tipo, Date fecha) {
        this.fecha = fecha;
        Tipo = tipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
