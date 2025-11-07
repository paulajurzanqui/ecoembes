package es.deusto.sd.auctions.entity;

import java.time.LocalTime;
import java.util.*;

public class Contenedor {
    private long id;
    private HashMap<Date, Estado> estados;
    private Estado ultimo;

    public Contenedor(long id, HashMap<Date, Estado> estados) {
        this.id = id;
        this.estados = estados;
        ultimo = null;
    }

    public Estado getUltimo() {
        return ultimo;
    }

    public void setUltimo(Estado ultimo) {
        this.ultimo = ultimo;
    }

    public HashMap<Date, Estado> getEstados() {
        return estados;
    }

    public void setEstados(HashMap<Date, Estado> estados) {
        this.estados = estados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Contenedor that = (Contenedor) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void anadir_estado(Estado estado){
        /**
         * Este metodo añade al contenedor un estado a su histórico además de actualizar el último
         */
        estados.put(estado.getFecha(), estado);
        ultimo = estado;
    }
}
