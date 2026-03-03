package dgtic.core.controller.dto;

import dgtic.core.validationn.NoEspacioNoVacio;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO  {
   // @NotBlank(message = "El nombre no puede ser vacio")
    @NoEspacioNoVacio
    private String nombre;

    @Pattern(regexp = ".*dgtic",message = "Correo no valido debe contener al final dgtic")
    private String correo;
    private String cp;
    @Pattern(regexp = "55[0-9]{8,8}" ,message = "El telefono debe ser de la Forma 55[0-9]{8,8}")
    private String tel;

    @NotNull
    @Range(min=18,max=60,message="No tienes la edad")
    private Integer edad;

}
