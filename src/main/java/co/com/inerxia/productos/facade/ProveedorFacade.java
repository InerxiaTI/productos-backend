package co.com.inerxia.productos.facade;

import co.com.inerxia.productos.facade.dto.ProveedorDto;
import co.com.inerxia.productos.facade.mapper.ProveedorMapper;
import co.com.inerxia.productos.service.ProveedorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProveedorFacade {

    private ProveedorMapper proveedorMapper;
    private ProveedorService proveedorService;

    public ProveedorFacade(ProveedorMapper proveedorMapper, ProveedorService proveedorService) {
        this.proveedorMapper = proveedorMapper;
        this.proveedorService = proveedorService;
    }

    public ProveedorDto findById(Integer id){
        return proveedorMapper.toDto(proveedorService.findById(id));
    }

    public List<ProveedorDto> findAll(){
        return proveedorMapper.toDto(proveedorService.findAll());
    }

    public ProveedorDto create(ProveedorDto proveedorDto){
        return proveedorMapper.toDto(proveedorService.create(proveedorMapper.toEntity(proveedorDto)));
    }

    public ProveedorDto edit(ProveedorDto proveedorDto){
        return proveedorMapper.toDto(proveedorService.edit(proveedorMapper.toEntity(proveedorDto)));
    }

    public void delete(Integer id) {
        proveedorService.delete(id);
    }
}
