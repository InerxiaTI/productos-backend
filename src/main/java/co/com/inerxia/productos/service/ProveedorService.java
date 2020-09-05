package co.com.inerxia.productos.service;

import co.com.inerxia.productos.model.Proveedor;
import co.com.inerxia.productos.model.ProveedorRepository;
import co.com.inerxia.productos.util.exception.DataNotFoundException;
import co.com.inerxia.productos.util.exception.ObjectNoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProveedorService {

    private ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public Proveedor findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return proveedorRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.proveedor"));
    }

    public List<Proveedor> findAll(){
        List<Proveedor> proveedorList = proveedorRepository.findAll();
        if (proveedorList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.proveedor");
        }
        return proveedorList;
    }

    public Proveedor create(Proveedor proveedor){
        if(Objects.nonNull(proveedor.getId())){
            Optional<Proveedor> proveedorOptional = proveedorRepository.findById(proveedor.getId());
            if(proveedorOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.proveedor");
            }
        }
        return proveedorRepository.save(proveedor);
    }

    public Proveedor edit(Proveedor proveedor){
        if(Objects.isNull(proveedor.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Proveedor proveedorTx = proveedorRepository.findById(proveedor.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.proveedor"));

        proveedorTx.setNombre_empresa(proveedor.getNombre_empresa());
        proveedorTx.setTelefono_empresa(proveedor.getTelefono_empresa());
        proveedorTx.setDireccion_empresa(proveedor.getDireccion_empresa());
        proveedorTx.setNombre_vendedor(proveedor.getNombre_vendedor());
        proveedorTx.setTelefono_vendedor(proveedor.getTelefono_vendedor());
        proveedorTx.setObservacion(proveedor.getObservacion());

        return proveedorTx;
    }

    public void delete(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        proveedorRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.proveedor"));
        proveedorRepository.deleteById(id);
    }
}
