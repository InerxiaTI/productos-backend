package co.com.inerxia.productos.facade.mapper;

import co.com.inerxia.productos.facade.dto.ProveedorDto;
import co.com.inerxia.productos.model.Proveedor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProveedorMapper extends EntityMapper<ProveedorDto, Proveedor>{
}
