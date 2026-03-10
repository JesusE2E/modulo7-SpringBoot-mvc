package dgtic.core.service;

import dgtic.core.model.dto.CategoriaDTO;
import dgtic.core.model.dto.CiudadDTO;
import dgtic.core.model.dto.PaisDTO;
import dgtic.core.model.dto.ProductoDTO;
import dgtic.core.repository.CategoriaRepository;
import dgtic.core.repository.CiudadRepository;
import dgtic.core.repository.PaisRepository;
import dgtic.core.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisCiudadServicio {
@Autowired
    private PaisRepository paisRepository;
    @Autowired
    private CiudadRepository ciudadRepository;

    //Obtenern el pais
public List<PaisDTO> getPaises(){
    return paisRepository.obtenerPaisesDTO();
}

//REcibiendo La categoria
    public List<CiudadDTO> getCiudadesPorIdPais(Long idPais){
    return ciudadRepository.obtenerCiudadesPorPais(idPais);
    }
}
