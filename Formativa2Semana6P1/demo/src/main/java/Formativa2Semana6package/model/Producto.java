package Formativa2Semana6package.model;
import jakarta.persistence.*;



@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long codigo;
    @Column(name= "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

     //Getter y Setters
     public Long getCodigo()
     {
         return codigo;
     }

     public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
 
     public String getNombre()
     {
         return nombre;
     }

     public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

     
}
