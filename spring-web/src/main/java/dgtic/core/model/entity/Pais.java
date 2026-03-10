package dgtic.core.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Long idPais;
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="pais",cascade = CascadeType.ALL)
    private List<Ciudad> ciudades;


    public Pais(String nombre) {
        this.nombre = nombre;
    }

}
