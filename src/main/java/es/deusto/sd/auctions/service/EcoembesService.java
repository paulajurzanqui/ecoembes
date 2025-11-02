package es.deusto.sd.auctions.service;

import es.deusto.sd.auctions.entity.Contenedor;
import es.deusto.sd.auctions.entity.Estado;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class EcoembesService {
    private HashMap<Long, Contenedor> contenedores;
    private HashMap<Long, TreeMap<Date, Estado.tipo>> estados; //long = id de un contenedor
    final LocalTime HORA_ACTUALIZACION = LocalTime.of(3, 00);

    public HashMap<Long, Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(HashMap<Long, Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public HashMap<Long, TreeMap<Date, Estado.tipo>> getEstados() {
        return estados;
    }

    public void setEstados(HashMap<Long, TreeMap<Date, Estado.tipo>> estados) {
        this.estados = estados;
    }

    public EcoembesService(HashMap<Long, Contenedor> contenedores, HashMap<Long, TreeMap<Date, Estado.tipo>> estados) {
        //this.contenedores = contenedores;
        //this.estados = estados;

        contenedores = new HashMap<>();
        contenedores.put(00001L, new Contenedor(00001L, 00.00, 00.00));
        estados = new HashMap<>();
        estados.put(00001L, new TreeMap<>());
        estados.get(00001L).put(new Date(2025, 01, 01),Estado.tipo.Verde);
        estados.get(00001L).put(new Date(2025, 01, 02),Estado.tipo.Verde);
        estados.get(00001L).put(new Date(2025, 01, 03),Estado.tipo.Naranja);
        estados.get(00001L).put(new Date(2025, 01, 04),Estado.tipo.Rojo);
    }

    //Get estado de los contenedores entre fechas
    public List<Estado.tipo> consulta_entre_fechas(Contenedor contenedor, Date inicio, Date fin){
        /**
         * Este metodo devolverá la lista con un treemap de fecha-estado de un contenedor en concreto.
         */
        long id = contenedor.getId();
        TreeMap<Date, Estado.tipo> estados_contenedor = estados.get(id);
        TreeMap<Date, Estado.tipo> result = new TreeMap<>();


        for(Date fecha : estados_contenedor.keySet()){
            if(fecha.before(fin) && fecha.after(inicio)) result.put(fecha, estados_contenedor.get(fecha));
        }

        return new ArrayList<Estado.tipo>(result.values());
    }
}