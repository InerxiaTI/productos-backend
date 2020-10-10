package co.com.inerxia.productos.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p JOIN p.proveedor_fk pd WHERE (p.nombre LIKE %:texto% OR p.descripcion LIKE %:texto% OR pd.nombre_empresa LIKE %:texto%)")
    List<Producto> consultarPorVarios(@Param("texto") String texto);

}
