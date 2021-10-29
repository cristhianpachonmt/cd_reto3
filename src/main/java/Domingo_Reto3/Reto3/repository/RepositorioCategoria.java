package Domingo_Reto3.Reto3.repository;

/**
 * Repository que es manejado por JPA de la tabla y clase Categoria
 * 
 * @since 2021-10-22
 * @version 3.0
 * @author Mateo Pachón
 * 
 */

import Domingo_Reto3.Reto3.interfaces.InterfaceCategoria;
import Domingo_Reto3.Reto3.model.Categoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioCategoria {
      @Autowired
    private InterfaceCategoria crud;
    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }

    public Categoria save(Categoria Categoria){
        return crud.save(Categoria);
    }
    public void delete(Categoria Categoria){
       crud.delete(Categoria);
    }
}

