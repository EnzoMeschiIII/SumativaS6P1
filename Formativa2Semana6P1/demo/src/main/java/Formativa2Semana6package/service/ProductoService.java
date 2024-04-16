package Formativa2Semana6package.service;

import java.util.List;
import java.util.Optional;

import Formativa2Semana6package.model.Producto;

public interface ProductoService {
    List<Producto> getAllProductos();
    Optional<Producto> getProductoByCodigo(Long codigo);
    Producto createProducto(Producto producto);
    Producto updateProducto(Long codigo, Producto producto);
    void deleteProducto(Long codigo);
}
