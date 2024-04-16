package Formativa2Semana6package.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa2Semana6package.model.Producto;
import Formativa2Semana6package.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoByCodigo(Long id) {
        return productoRepository.findById(id);
    }
    
    @Override
    public Producto createProducto(Producto producto){
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Long codigo, Producto producto){
        if(productoRepository.existsById(codigo)){
            producto.setCodigo(codigo);
            return productoRepository.save(producto);
        }
        else{
            return null;
        }

    }

    @Override
    public void deleteProducto(Long codigo){
        productoRepository.deleteById(codigo);
    }
}

