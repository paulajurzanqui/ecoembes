package es.deusto.sd.auctions.service;

import es.deusto.sd.auctions.dao.CamionRepository;
import es.deusto.sd.auctions.dto.CamionRequestDTO;
//import es.deusto.sd.auctions.dto.CamionRequestDTO;
import es.deusto.sd.auctions.entity.Camion;
import es.deusto.sd.auctions.entity.Contenedor;
import es.deusto.sd.auctions.entity.Estado;
import es.deusto.sd.auctions.entity.PlantaDeReciclaje;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class EcoembesService {
    private HashMap<Long, Contenedor> contenedores;
    private HashMap<Long, PlantaDeReciclaje> plantas;
    private HashMap<Long, List<Camion>> camiones; //El long es el id de una planta de reciclaje, y luego una lista de camiones qué van a ella.

    // NUEVO: Añade los repositories
    private final CamionRepository camionRepository;


    public HashMap<Long, Contenedor> getContenedores() {
        return contenedores;
    }

    public void setContenedores(HashMap<Long, Contenedor> contenedores) {
        this.contenedores = contenedores;
    }

    public EcoembesService(HashMap<Long, Contenedor> contenedores, CamionRepository camionRepository) {
        this.contenedores = contenedores;
        this.camionRepository = camionRepository;
    }

    public HashMap<Long, PlantaDeReciclaje> getPlantas() {
        return plantas;
    }

    public void setPlantas(HashMap<Long, PlantaDeReciclaje> plantas) {
        this.plantas = plantas;
    }

    public EcoembesService(CamionRepository camionRepository) {
        this.camionRepository = camionRepository;

    }

    //Get estado de los contenedores entre fechas
    public List<Estado> consulta_entre_fechas(Contenedor contenedor, Date inicio, Date fin){
        /**
         * Este metodo devolverá la lista con un treemap de fecha-estado de un contenedor en concreto.
         */
        //TODO
        return null;
    }

    //Get estado de una planta en una fecha determinada
    public double capacidad_planta_fecha(PlantaDeReciclaje planta, Date fecha){
        return planta.getHistorico().get(fecha);
    }

    //Post crear un camión
    /*public void crear_camion(CamionRequestDTO dto, PlantaDeReciclaje planta){
        /**
         * Con este metodo podemos añadir un camión, estos están organizados en un hashMap que tiene como clave las plantas de reciclaje,
         * y como valor un arraylist de todos los camiones que van a esta. Los camiones tienen dentro un array con todos los ids de los
         * contenedores que conteienen, además de un id de la planta y una fecha que indican cuando y donde van.
         */

        /*if(!plantas.containsKey(planta.getId())){
            //Error de que no se puede asignar a una planta que no existe
        }

        Camion camion = new Camion();

        List<Contenedor> contenedoresCamion = new ArrayList<>();
        for(long id: dto.getContenedores()){
            camion.getContenedores().add(contenedores.get(id));
        }

        if (camiones.containsKey(planta.getId())){
            camiones.get(planta.getId()).add(camion);
        }else{
            camiones.put(planta.getId(), new ArrayList<>());
            camiones.get(planta.getId()).add(camion);
        }
    }*/

    @Transactional
    public CamionRequestDTO crear_camion(CamionRequestDTO dto, PlantaDeReciclaje planta) {
        return null;
    }



}