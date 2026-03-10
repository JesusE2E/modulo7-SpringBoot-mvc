package dgtic.core.service;

import dgtic.core.model.dto.CategoriaDTO;
import dgtic.core.model.dto.ProductoDTO;
import dgtic.core.repository.CategoriaRepository;
import dgtic.core.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProductoServicio {
@Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;
public List<CategoriaDTO> getCategorias(){
    return categoriaRepository.findAll().stream().map(categoria ->

    new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombre())

    ).toList();
}

//REcibiendo La categoria
    public List<ProductoDTO> getProductosPorCategoria(Long categoriaId){
    return productoRepository.encontrarPorIdCategoria(categoriaId);
    }
}
