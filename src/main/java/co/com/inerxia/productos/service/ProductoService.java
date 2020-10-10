package co.com.inerxia.productos.service;

import co.com.inerxia.productos.model.Producto;
import co.com.inerxia.productos.model.ProductoRepository;
import co.com.inerxia.productos.util.exception.DataNotFoundException;
import co.com.inerxia.productos.util.exception.ObjectNoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return productoRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.producto"));
    }

    public List<Producto> findAll(){
        List<Producto> productoList = productoRepository.findAll();
        if (productoList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.producto");
        }
        return productoList;
    }

    public List<Producto> consultarPorVarios(String texto){
        List<Producto> productoList = productoRepository.consultarPorVarios(texto);
        if (productoList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.producto");
        }
        return productoList;
    }

    public Producto create(Producto producto){
        if(Objects.nonNull(producto.getId())){
            Optional<Producto> productoOptional = productoRepository.findById(producto.getId());
            if(productoOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.producto");
            }
        }
        return productoRepository.save(producto);
    }

    public Producto edit(Producto producto){
        if(Objects.isNull(producto.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Producto productoTx = productoRepository.findById(producto.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.producto"));

        productoTx.setNombre(producto.getNombre());
        productoTx.setDescripcion(producto.getDescripcion());
        productoTx.setPrecio_compra(producto.getPrecio_compra());
        productoTx.setPrecio_venta(producto.getPrecio_venta());
        productoTx.setIva(producto.getIva());
        productoTx.setMarca(producto.getMarca());
        productoTx.setFecha_compra(producto.getFecha_compra());
        productoTx.setFoto(producto.getFoto());
        productoTx.setIdProveedor_fk(producto.getIdProveedor_fk());

        return productoTx;
    }

    public void delete(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        productoRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.producto"));
        productoRepository.deleteById(id);
    }
}
