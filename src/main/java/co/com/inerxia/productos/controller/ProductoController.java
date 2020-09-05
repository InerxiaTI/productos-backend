package co.com.inerxia.productos.controller;

import co.com.inerxia.productos.facade.ProductoFacade;
import co.com.inerxia.productos.facade.dto.ProductoDto;
import co.com.inerxia.productos.util.StandardResponse;
import co.com.inerxia.productos.util.exception.DataBaseException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private ProductoFacade productoFacade;

    public ProductoController(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el producto por id", response = ProductoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductoDto>> findById(@PathVariable(value = "id") Integer id){
        ProductoDto productoDto = productoFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                productoDto));
    }

    @GetMapping("/get-todos")
    @ApiOperation(value = "Obtiene todos los productos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ProductoDto>>> findAll(){
        List<ProductoDto> productoDtoList = productoFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                productoDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Crea un producto", response = ProductoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductoDto>> create(@Valid @RequestBody ProductoDto productoDto){
        ProductoDto productoDto1 = productoFacade.create(productoDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "producto.crear.exito",
                productoDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un producto", response = ProductoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductoDto>> edit(@Valid @RequestBody ProductoDto productoDto){
        ProductoDto productoDto1 = productoFacade.edit(productoDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "producto.editar.exito",
                productoDto1));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un producto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProductoDto>> delete(@PathVariable(value = "id") Integer id) {
        try {
            productoFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "producto.eliminar.exito"));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("exception.eliminar.producto");
        }
    }
}
