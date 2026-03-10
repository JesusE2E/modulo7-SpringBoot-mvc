package dgtic.core.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
private Long idProducto;
private String nombre;

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
