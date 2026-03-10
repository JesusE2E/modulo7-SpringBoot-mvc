package dgtic.core.repository;

import dgtic.core.model.dto.CiudadDTO;
import dgtic.core.model.dto.PaisDTO;
import dgtic.core.model.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CiudadRepository extends JpaRepository<Pais,Long> {
    @Query(value = "SELECT new dgtic.core.model.dto.CiudadDTO(c.idCiudad, c.nombre) FROM Ciudad c inner join c.pais p WHERE p.idPais=:idPais")
    List<CiudadDTO> obtenerCiudadesPorPais(@Param("idPais")Long idPais);
}
