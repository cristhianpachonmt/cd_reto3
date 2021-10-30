package Domingo_Reto3.Reto3.repository;

/**
 * Repository que es manejado por JPA de la tabla y clase Reservaciones
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */

import Domingo_Reto3.Reto3.interfaces.InterfaceReservaciones;
import Domingo_Reto3.Reto3.model.Cliente;
import Domingo_Reto3.Reto3.model.ContadorClientes;
import Domingo_Reto3.Reto3.model.Reservaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservaciones {
    @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }
    
    public List<Reservaciones> ReservationStatus(String status){
        return crud4.findAllByStatus(status);
    }
    public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    public List<ContadorClientes> getClientesRepositorio(){
         List<ContadorClientes> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservacionesByCliente();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
         }
         return res;
     }
}
