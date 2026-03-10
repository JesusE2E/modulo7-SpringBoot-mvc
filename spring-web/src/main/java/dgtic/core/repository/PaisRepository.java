package dgtic.core.repository;

import dgtic.core.model.dto.PaisDTO;
import dgtic.core.model.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais,Long> {
    @Query(value = "SELECT new dgtic.core.model.dto.PaisDTO(p.idPais, p.nombre) FROM Pais p")
    List<PaisDTO> obtenerPaisesDTO();


}
