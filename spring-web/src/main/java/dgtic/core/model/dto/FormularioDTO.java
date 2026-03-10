package dgtic.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormularioDTO {
private Long categoriaId;
private String productoId;

    @Override
    public String toString() {
        return "FormularioDTO{" +
                "categoriaId=" + categoriaId +
                ", productoId='" + productoId + '\'' +
                '}';
    }
}
