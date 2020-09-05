package co.com.inerxia.productos.facade;

import co.com.inerxia.productos.facade.dto.ProductoDto;
import co.com.inerxia.productos.facade.mapper.ProductoMapper;
import co.com.inerxia.productos.service.ProductoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoFacade {

    private ProductoMapper productoMapper;
    private ProductoService productoService;

    private ProveedorFacade proveedorFacade;

    public ProductoFacade(ProductoMapper productoMapper, ProductoService productoService, ProveedorFacade proveedorFacade) {
        this.productoMapper = productoMapper;
        this.productoService = productoService;
        this.proveedorFacade = proveedorFacade;
    }

    public ProductoDto findById(Integer id){
        return productoMapper.toDto(productoService.findById(id));
    }

    public List<ProductoDto> findAll(){
        return productoMapper.toDto(productoService.findAll());
    }

    public ProductoDto create(ProductoDto productoDto){
        proveedorFacade.findById(productoDto.getIdProveedor_fk());
        return productoMapper.toDto(productoService.create(productoMapper.toEntity(productoDto)));
    }

    public ProductoDto edit(ProductoDto productoDto){
        proveedorFacade.findById(productoDto.getIdProveedor_fk());
        return productoMapper.toDto(productoService.edit(productoMapper.toEntity(productoDto)));
    }

    public void delete(Integer id) {
        productoService.delete(id);
    }

}
