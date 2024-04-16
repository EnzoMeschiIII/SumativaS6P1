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
import Formativa2Semana6package.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Producto> getProductoByCodigo(@PathVariable Long codigo) {
        Optional<Producto> productoExiste = productoService.getProductoByCodigo(codigo);

        if (productoExiste.isPresent()) {
            return ResponseEntity.ok(productoExiste.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {

        Optional<Producto> productoExiste = productoService.getProductoByCodigo(producto.getCodigo());
        if (productoExiste.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Producto createdProducto = productoService.createProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long codigo) {

        Optional<Producto> productoExiste = productoService.getProductoByCodigo(codigo);
        if (!productoExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        productoService.deleteProducto(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long codigo, @RequestBody Producto producto) {

        Optional<Producto> productoExiste = productoService.getProductoByCodigo(codigo);
        if (!productoExiste.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Producto existente = productoExiste.get();

        existente.setNombre(producto.getNombre());

        Producto updatedProducto = productoService.updateProducto(codigo, existente);
        return ResponseEntity.ok(updatedProducto);
    }

    

}
