package es.deusto.sd.auctions.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeMap;

public class Contenedor {
    private long id;
    private double latitud, longitud;
    private HashSet<Estado> estado_en_fechas;
    final LocalTime HORA_ACTUALIZACION = LocalTime.of(3, 00);

    public Contenedor(long id, double latitud, double longitud) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        estado_en_fechas = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "id=" + id +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }

    public TreeMap<Date, Estado.tipo> consulta_estado_fechas(Date inicio, Date fin){
        /**
         * Este metodo me devuleve un Treemap que tiene como key una fecha, y con esa fecha guardado un estado, que hace referencia a lo lleno
         * que estaba el contenedor en dicha fecha.
         * Como parámetro recive dos fechas de tipo java.Util.Date. El primer parámetro es la fecha de inicio y el segundo la final.
        */
        TreeMap<Date, Estado.tipo> result = new TreeMap<>();
        for (Estado estado : this.estado_en_fechas){
            if(result.containsKey(estado.getFecha())) continue;
            if(estado.getFecha().after(inicio) && estado.getFecha().before(fin)) result.put(estado.getFecha(), estado.getLlenado());
        }
        return result;
    }

}
