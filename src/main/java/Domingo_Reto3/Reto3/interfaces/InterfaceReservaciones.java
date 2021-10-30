/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Domingo_Reto3.Reto3.interfaces;
/**
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y clase Reservaciones * 
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */
import Domingo_Reto3.Reto3.model.Reservaciones;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer> {
    
    public List<Reservaciones> findAllByStatus(String status);
    
    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date datetwo);
    
    //SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservacionesByCliente();
}

