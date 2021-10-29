package Domingo_Reto3.Reto3.repository;

/**
 * Repository que es manejado por JPA de la tabla y clase Quadbike
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */

import Domingo_Reto3.Reto3.interfaces.InterfaceQuadbike;
import Domingo_Reto3.Reto3.model.Quadbike;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioQuadbike {
    
    @Autowired
    private InterfaceQuadbike crud;

    public List<Quadbike> getAll(){
        return (List<Quadbike>) crud.findAll();
    }

    public Optional<Quadbike> getQuadbike(int id){
        return crud.findById(id);
    }

    public Quadbike save(Quadbike quadbike){
        return crud.save(quadbike);
    }
    public void delete(Quadbike quadbike){
        crud.delete(quadbike);
    }
    
}
