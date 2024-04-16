package Formativa2Semana6package.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "contraseña")
    private String contraseña;
    @Column(name = "rut")
    private String rut;
    @Column(name="genero")
    private String rol;
    @Column(name="direccion")
    private String direccion;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<DetalleCompra> detalleCompras;

     @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Producto> productos;
    
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<DetalleCompra> getDetalleCompras() {
        return detalleCompras;
    }

    public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

}
