package es.deusto.sd.auctions.service;

import es.deusto.sd.auctions.entity.Contenedor;
import es.deusto.sd.auctions.entity.Estado;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class EcoembesService {
    private HashMap<Long, Contenedor> contenedores;
    private HashMap<Long, TreeMap<Date, Estado>> estados; //long = id de un contenedor
    final LocalTime HORA_ACTUALIZACION = LocalTime.of(3, 00);

    public HashMap<Long, Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(HashMap<Long, Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public HashMap<Long, TreeMap<Date, Estado>> getEstados() {
        return estados;
    }

    public void setEstados(HashMap<Long, TreeMap<Date, Estado>> estados) {
        this.estados = estados;
    }

    public EcoembesService(HashMap<Long, Contenedor> contenedores, HashMap<Long, TreeMap<Date, Estado.tipo>> estados) {
        //this.contenedores = contenedores;
        //this.estados = estados;

        contenedores = new HashMap<>();
        contenedores.put(00001L, new Contenedor(00001L, 00.00, 00.00));
        estados = new HashMap<>();
        estados.put(00001L, new TreeMap<>());
        estados.get(00001L).put(new Date(125, 01, 01),Estado.tipo.Verde);
        estados.get(00001L).put(new Date(125, 01, 02),Estado.tipo.Verde);
        estados.get(00001L).put(new Date(125, 01, 03),Estado.tipo.Naranja);
        estados.get(00001L).put(new Date(125, 01, 04),Estado.tipo.Rojo);
    }

    public EcoembesService() {
        //this.contenedores = contenedores;
        //this.estados = estados;

        contenedores = new HashMap<>();
        contenedores.put(00001L, new Contenedor(00001L, 00.00, 00.00));
        estados = new HashMap<>();
        estados.put(00001L, new TreeMap<>());
        estados.get(00001L).put(new Date(125, 0, 01),new Estado(new Date(125, 0, 01), 00.10));
        estados.get(00001L).put(new Date(125, 0, 02),new Estado(new Date(125, 0, 02), 00.12));
        estados.get(00001L).put(new Date(125, 0, 03),new Estado(new Date(125, 0, 03), 00.86));
        estados.get(00001L).put(new Date(125, 0, 04),new Estado(new Date(125, 0, 01), 01));
    }

    //Get estado de los contenedores entre fechas
    public List<Estado> consulta_entre_fechas(Contenedor contenedor, Date inicio, Date fin){
        /**
         * Este metodo devolverá la lista con un treemap de fecha-estado de un contenedor en concreto.
         */
        long id = contenedor.getId();
        TreeMap<Date, Estado> estados_contenedor = estados.get(id);
        TreeMap<Date, Estado> result = new TreeMap<>();

        System.out.println("inicio: " + inicio.toString());
        System.out.println("fin: "+ fin.toString());


        for(Date fecha : estados_contenedor.keySet()){
            System.out.println(fecha.toString());
            if(!fecha.after(fin) && !fecha.before(inicio)){
                result.put(fecha, estados_contenedor.get(fecha));
            }
        }

        return new ArrayList<Estado>(result.values());
    }
}