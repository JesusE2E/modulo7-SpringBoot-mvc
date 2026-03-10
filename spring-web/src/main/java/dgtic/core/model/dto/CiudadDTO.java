package dgtic.core.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CiudadDTO {
    private Long idCiudad;
    private String nombre;
}
