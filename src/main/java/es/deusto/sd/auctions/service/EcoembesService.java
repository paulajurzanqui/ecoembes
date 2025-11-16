package es.deusto.sd.auctions.service;

//import es.deusto.sd.auctions.dto.CamionRequestDTO;
import es.deusto.sd.auctions.entity.Camion;
import es.deusto.sd.auctions.entity.Contenedor;
import es.deusto.sd.auctions.entity.Estado;
import es.deusto.sd.auctions.entity.PlantaDeReciclaje;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class EcoembesService {
    private HashMap<Long, Contenedor> contenedores;
    private HashMap<Long, PlantaDeReciclaje> plantas;
    private HashMap<Long, List<Camion>> camiones; //El long es el id de una planta de reciclaje, y luego una lista de camiones qué van a ella.

    public HashMap<Long, Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(HashMap<Long, Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public EcoembesService(HashMap<Long, Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public HashMap<Long, PlantaDeReciclaje> getPlantas() {
        return plantas;
    }

    public void setPlantas(HashMap<Long, PlantaDeReciclaje> plantas) {
        this.plantas = plantas;
    }

    public EcoembesService() {
        //this.contenedores = contenedores;
        //this.estados = estados;
        //this.camiones = camiones;
        HashMap<Date, Estado>estados = new HashMap<>();
        estados.put(new Date(125, 0, 01),new Estado(new Date(125, 0, 01), 00.10));
        estados.put(new Date(125, 0, 02),new Estado(new Date(125, 0, 02), 00.12));
        estados.put(new Date(125, 0, 03),new Estado(new Date(125, 0, 03), 00.86));
        estados.put(new Date(125, 0, 04),new Estado(new Date(125, 0, 04), 01));

        contenedores = new HashMap<>();
        contenedores.put(00001L, new Contenedor(1L, estados));
        contenedores.put(00002L, new Contenedor(2L, estados));
        contenedores.put(00003L, new Contenedor(3L, estados));
        contenedores.get(1L).anadir_estado(new Estado(new Date(125,0,05), 0.7));
        contenedores.get(2L).anadir_estado(new Estado(new Date(125,0,05), 0.82));
        contenedores.get(3L).anadir_estado(new Estado(new Date(125,0,05), 0.4));

        plantas = new HashMap<>();
        plantas.put(1L, new PlantaDeReciclaje(100,1L));
        HashMap<Date, Double> historico = new HashMap<>();
        historico.put(new Date(125, 00, 01), 99.00);
        historico.put(new Date(125, 00, 02), 90.00);

        plantas.get(1L).setHistorico(historico);
        plantas.get(1L).actualizar_capacidad(89, new Date(125,00,03));
        this.camiones = new HashMap<>();
    }

    //Get estado de los contenedores entre fechas
    public List<Estado> consulta_entre_fechas(Contenedor contenedor, Date inicio, Date fin){
        /**
         * Este metodo devolverá la lista con un treemap de fecha-estado de un contenedor en concreto.
         */
        HashMap<Date, Estado> estados_contenedor = contenedor.getEstados();
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

    //Get estado de una planta en una fecha determinada
    public double capacidad_planta_fecha(PlantaDeReciclaje planta, Date fecha){
        return planta.getHistorico().get(fecha);
    }

    //Post crear un camión
//    public void crear_camion(CamionRequestDTO dto, long id_planta){
        /**
         * Con este metodo podemos añadir un camión, estos están organizados en un hashMap que tiene como clave las plantas de reciclaje,
         * y como valor un arraylist de todos los camiones que van a esta. Los camiones tienen dentro un array con todos los ids de los
         * contenedores que conteienen, además de un id de la planta y una fecha que indican cuando y donde van.
         */

//        if(!plantas.containsKey(id_planta)){
            //Error de que no se puede asignar a una planta que no existe
//        }

//        Camion camion = new Camion(dto.getContenedores(), id_planta, dto.getFecha());

//        if (camiones.containsKey(id_planta)){
//            camiones.get(id_planta).add(camion);
//        }else{
//            camiones.put(id_planta, new ArrayList<>());
//            camiones.get(id_planta).add(camion);
//        }
//    }

}