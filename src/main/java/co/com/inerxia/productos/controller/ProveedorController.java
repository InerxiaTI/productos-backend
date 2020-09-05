package co.com.inerxia.productos.controller;

import co.com.inerxia.productos.facade.ProveedorFacade;
import co.com.inerxia.productos.facade.dto.ProveedorDto;
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
@RequestMapping("/proveedor")
public class ProveedorController {

    private ProveedorFacade proveedorFacade;

    public ProveedorController(ProveedorFacade proveedorFacade) {
        this.proveedorFacade = proveedorFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el proveedor por id", response = ProveedorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProveedorDto>> findById(@PathVariable(value = "id") Integer id){
        ProveedorDto proveedorDto = proveedorFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                proveedorDto));
    }

    @GetMapping("/get-todos")
    @ApiOperation(value = "Obtiene todos los proveedores", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ProveedorDto>>> findAll(){
        List<ProveedorDto> proveedorDtoList = proveedorFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                proveedorDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Crea un proveedor", response = ProveedorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProveedorDto>> create(@Valid @RequestBody ProveedorDto proveedorDto){
        ProveedorDto proveedorDto1 = proveedorFacade.create(proveedorDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "proveedor.crear.exito",
                proveedorDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un proveedor", response = ProveedorDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProveedorDto>> edit(@Valid @RequestBody ProveedorDto proveedorDto){
        ProveedorDto proveedorDto1 = proveedorFacade.edit(proveedorDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "proveedor.editar.exito",
                proveedorDto1));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Elimina un proveedor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ProveedorDto>> delete(@PathVariable(value = "id") Integer id) {
        try {
            proveedorFacade.delete(id);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "proveedor.eliminar.exito"));
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("exception.eliminar.proveedor");
        }
    }
}
