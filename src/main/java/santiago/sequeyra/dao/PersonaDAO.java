package santiago.sequeyra.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import santiago.sequeyra.domain.Persona;


public interface PersonaDAO extends CrudRepository<Persona, Integer> {

    //CrudRepository tiene todas las acciones CRUD mas conocidas, para no tener que definirlas.
        
    
    
}
