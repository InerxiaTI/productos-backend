package co.com.inerxia.productos.model;

import javax.persistence.*;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "nombre_empresa", nullable = false)
    private String nombre_empresa;

    @Column(name = "telefono_empresa")
    private String telefono_empresa;

    @Column(name = "direccion_empresa")
    private String direccion_empresa;

    @Column(name = "nombre_vendedor")
    private String nombre_vendedor;

    @Column(name = "telefono_vendedor")
    private String telefono_vendedor;

    @Column(name = "observacion")
    private String observacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getTelefono_vendedor() {
        return telefono_vendedor;
    }

    public void setTelefono_vendedor(String telefono_vendedor) {
        this.telefono_vendedor = telefono_vendedor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
