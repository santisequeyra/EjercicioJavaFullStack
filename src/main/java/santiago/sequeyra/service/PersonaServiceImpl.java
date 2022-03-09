package santiago.sequeyra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import santiago.sequeyra.dao.PersonaDAO;
import santiago.sequeyra.domain.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDAO personaDAO;
    
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDAO.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
       personaDAO.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
       personaDAO.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDAO.findById(persona.getIdpersonas()).orElse(null);
    }

    @Override
    public void borrarInvitados(List<Persona> personas) {
        personaDAO.deleteAll(personas);
    }

   
}
