package Formativa2Semana6package.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleCompra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "precio")
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "usuarioId") 
    private Usuario usuario;

     // Getter y setter
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}