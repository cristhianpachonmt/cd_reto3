package Domingo_Reto3.Reto3.service;

/**
 * Servicios CRUD de la tabla Reservaciones
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */

import Domingo_Reto3.Reto3.model.ContadorClientes;
import Domingo_Reto3.Reto3.repository.RepositorioReservaciones;
import Domingo_Reto3.Reto3.model.Reservaciones;
import Domingo_Reto3.Reto3.model.StatusReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservaciones {    
    /**
     * Creación de variable metodosCrud qu es de tipo Repositorio
     */
    @Autowired
    private RepositorioReservaciones metodosCrud;
    /**
     * Este método es para obtener todos los datos de la tabla Reservaciones
     * @return List de clase Reservacion
     */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * Este metodo para obtener los datos de la tabla reservaciones por Id
     * @param reservationId
     * @return Optional de clase Reservacion
     */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
     * Metodo para ingresar datos en la tabla reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**
     * Metodo para actualizar un dato de la tabla Reservaciones
     * @param reservation
     * @return valor de calse Reservacion
     */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }    
    /**
     * Metodo para borrar datos de la tabla Reservaciones por Id
     * @param reservationId
     * @return boolean
     */
    public StatusReservas getRepStatusRes(){
        List<Reservaciones>completed = metodosCrud.ReservationStatus("completed");
        List<Reservaciones>cancelled = metodosCrud.ReservationStatus("cancelled");        
        return new StatusReservas(completed.size(),cancelled.size());
    }
    
    public List<Reservaciones> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        } 
    }
    
    public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
    }
}
