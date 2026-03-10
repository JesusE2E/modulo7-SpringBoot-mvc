package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nombre;
//una categoria tiene muchos productos

  //  @OneToMany()
    //@JoinColumn(name ="nombre" )
    //private List<Producto> productos;
    }
