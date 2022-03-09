package santiago.sequeyra.service;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import santiago.sequeyra.domain.Persona;

public interface PersonaService {
    
    
    public List<Persona> listarPersonas();
    
    public void guardar (Persona persona);
    
    public void eliminar (Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
    void borrarInvitados(List<Persona> personas);   
        
}
