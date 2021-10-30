/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Domingo_Reto3.Reto3.interfaces;
/**
 * Esta interface implementa el Repository que es manejado por JPA de la tabla y clase Mensaje * 
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */
import Domingo_Reto3.Reto3.model.Mensaje;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer> {
    
}

