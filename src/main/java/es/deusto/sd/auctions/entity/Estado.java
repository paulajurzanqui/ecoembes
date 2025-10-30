package es.deusto.sd.auctions.entity;

import java.util.Date;
import java.util.Objects;

public class Estado {
    private tipo llenado;
    private Date fecha;
    private double cantidad; //En toneladas

    protected enum tipo{
        Verde, //0% - 80%
        Naranja, //80%-100%
        Rojo; //100%
    }

    public Estado(tipo llenado, Date fecha, double cantidad) {
        this.llenado = llenado;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public tipo getLlenado() {
        return llenado;
    }

    public void setLlenado(tipo llenado) {
        this.llenado = llenado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return fecha.equals(((Estado) o).fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(llenado, fecha);
    }
}
