package es.deusto.sd.auctions.entity;

import java.util.Date;
import java.util.HashMap;

public class PlantaDeReciclaje {
    private long id;
    private double capacidad_total;
    private double capacidad_actual;
    private HashMap<Date, Double> historico;

    public PlantaDeReciclaje(double capacidad_total, long id) {
        this.id = id;
        this.capacidad_total = capacidad_total;
        historico = new HashMap<>();
    }

    public HashMap<Date, Double> getHistorico() {
        return historico;
    }

    public void setHistorico(HashMap<Date, Double> historico) {
        this.historico = historico;
    }

    public double getCapacidad_total() {
        return capacidad_total;
    }

    public void setCapacidad_total(double capacidad_total) {
        this.capacidad_total = capacidad_total;
    }

    public double getCapacidad_actual() {
        return capacidad_actual;
    }

    public void setCapacidad_actual(double capacidad_actual) {
        this.capacidad_actual = capacidad_actual;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void actualizar_capacidad(double capacidad, Date fecha){
        capacidad_actual = capacidad;
        historico.put(fecha, capacidad);
    }
}
