package co.com.inerxia.productos.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_compra", nullable = false)
    private Double precio_compra;

    @Column(name = "precio_venta", nullable = false)
    private Double precio_venta;

    @Column(name = "iva", nullable = false)
    private Double iva;

    @Column(name = "marca")
    private String marca;

    @Column(name = "fecha_compra")
    private LocalDate fecha_compra;

    @Column(name = "foto")
    private String foto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="proveedor_fk", insertable = false, updatable = false, nullable = false)
    private Proveedor proveedor_fk;

    @Column(name="proveedor_fk",  nullable = false)
    private Integer idProveedor_fk;

    public Proveedor getProveedor_fk() {
        return proveedor_fk;
    }

    public void setProveedor_fk(Proveedor proveedor_fk) {
        this.proveedor_fk = proveedor_fk;
    }

    public Integer getIdProveedor_fk() {
        return idProveedor_fk;
    }

    public void setIdProveedor_fk(Integer idProveedor_fk) {
        this.idProveedor_fk = idProveedor_fk;
    }

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
}
