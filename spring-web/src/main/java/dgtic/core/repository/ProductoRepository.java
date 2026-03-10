package dgtic.core.repository;

import dgtic.core.model.dto.ProductoDTO;
import dgtic.core.model.entity.Categoria;
import dgtic.core.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query(value = "SELECT new dgtic.core.model.dto.ProductoDTO(p.idProducto,p.nombre) FROM Producto p  inner join p.categoria cat WHERE cat.idCategoria=:categoriaId")
    List<ProductoDTO> encontrarPorIdCategoria(@Param("categoriaId") Long categoriaId);
}
