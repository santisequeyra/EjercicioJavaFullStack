package santiago.sequeyra.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import lombok.Data;


@Data //lombok transforma clases de dominio en javabeans (les pone setters, getters, constructores, tostring, etc)
@Entity
@Table(name= "personas")
public class Persona implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idpersonas;
    
    @NotEmpty(message="El campo nombre no puede estar vacío.")
    private String nombre;
    
    @NotEmpty(message="El campo apellido no puede estar vacío.")
    private String apellido;
    
    @NotEmpty(message="El campo email no puede estar vacío.")
    @Email(message="No es un formato de correo electrónico válido.")
    private String email;
    
    @Pattern(regexp = "^[0-9.-]*$", message="El teléfono sólo puede contener números y guiones.")
    @NotEmpty(message="El campo telefono no puede estar vacío.")
    private String telefono;
    
    private int invitado;
    
    
}
