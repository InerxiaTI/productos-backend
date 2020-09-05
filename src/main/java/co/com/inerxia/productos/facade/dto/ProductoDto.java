package co.com.inerxia.productos.facade.dto;

import java.time.LocalDate;

public class ProductoDto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio_compra;
    private Double precio_venta;
    private Double iva;
    private String marca;
    private LocalDate fecha_compra;
    private String foto;
    private ProveedorDto proveedor_fk;
    private Integer idProveedor_fk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public ProveedorDto getProveedor_fk() {
        return proveedor_fk;
    }

    public void setProveedor_fk(ProveedorDto proveedor_fk) {
        this.proveedor_fk = proveedor_fk;
    }

    public Integer getIdProveedor_fk() {
        return idProveedor_fk;
    }

    public void setIdProveedor_fk(Integer idProveedor_fk) {
        this.idProveedor_fk = idProveedor_fk;
    }
}
