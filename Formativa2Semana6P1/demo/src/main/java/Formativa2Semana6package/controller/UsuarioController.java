package Formativa2Semana6package.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Formativa2Semana6package.model.Producto;
import Formativa2Semana6package.model.Usuario;
import Formativa2Semana6package.model.DetalleCompra;
import Formativa2Semana6package.service.ProductoService;
import Formativa2Semana6package.service.UsuarioService;
import Formativa2Semana6package.service.DetalleCompraService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public List<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuarioExiste = usuarioService.getUsuarioById(id);

        if (usuarioExiste.isPresent()) {
            return ResponseEntity.ok(usuarioExiste.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {

    Optional<Usuario> usuarioExiste = usuarioService.getUsuarioById(usuario.getId());
    if (usuarioExiste.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    if (usuario.getProductos() != null) {
        for (Producto producto : usuario.getProductos()) {
            Optional<Producto>productoExiste = productoService.getProductoByCodigo(producto.getCodigo());
            if (productoExiste.isEmpty()) {
                Producto nuevoProducto = productoService.createProducto(producto);
                if (nuevoProducto == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }
    }

    if (usuario.getDetalleCompras() != null) {
        for (DetalleCompra detalleCompra : usuario.getDetalleCompras()) {
            Optional<DetalleCompra> detalleCompraExiste = detalleCompraService.getDetalleCompraById(detalleCompra.getId());
            if (detalleCompraExiste.isEmpty()) {
                DetalleCompra nuevoDetalleCompra = detalleCompraService.createDetalleCompra(detalleCompra);
                if (nuevoDetalleCompra == null) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                }
            }
        }
    }

    Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
    if (nuevoUsuario == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    return ResponseEntity.ok(nuevoUsuario);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExiste = usuarioService.getUsuarioById(id);
        if (!usuarioExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Usuario existente = usuarioExiste.get();
    
        existente.setNombre(usuario.getNombre());
        existente.setContraseña(usuario.getContraseña());
        existente.setRut(usuario.getRut());
        existente.setRol(usuario.getRol());
        existente.setDireccion(usuario.getDireccion());
        existente.setProductos(usuario.getProductos());
        existente.setDetalleCompras(usuario.getDetalleCompras());
    
        Usuario updateUsuario = usuarioService.updateUsuario(id, existente);
        return ResponseEntity.ok(updateUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioExiste = usuarioService.getUsuarioById(id);
        if (!usuarioExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }
    
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}


