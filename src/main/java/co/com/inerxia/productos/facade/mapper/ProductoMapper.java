package co.com.inerxia.productos.facade.mapper;

import co.com.inerxia.productos.facade.dto.ProductoDto;
import co.com.inerxia.productos.model.Producto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProveedorMapper.class})
public interface ProductoMapper extends EntityMapper<ProductoDto, Producto>{
}
