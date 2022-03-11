package santiago.sequeyra.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import santiago.sequeyra.domain.Persona;
import santiago.sequeyra.service.PersonaService;

@Controller
public class MainController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {

        List<Persona> personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);

        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errors) {
        if (errors.hasErrors()) {
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idpersonas}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar/{idpersonas}")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/invitar/{idpersonas}")
    public String invitar(Persona persona){
        persona = personaService.encontrarPersona(persona);
        persona.setInvitado(1);
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/desinvitar/{idpersonas}")
    public String desinvitar(Persona persona){
        persona = personaService.encontrarPersona(persona);
        persona.setInvitado(0);
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/enviarinvitaciones")
    public String enviarInvitaciones() {
        List<Persona> todasPersonas=personaService.listarPersonas(); 
        
        List<Persona> personas = new ArrayList();
        for(Persona p:todasPersonas){
            if(p.getInvitado()==1){
                personas.add(p);
            }
        }
        personaService.borrarInvitados(personas);
                
        return "redirect:/";
    }

}
