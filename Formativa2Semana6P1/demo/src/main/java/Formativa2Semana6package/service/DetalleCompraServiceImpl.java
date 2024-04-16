package Formativa2Semana6package.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa2Semana6package.model.DetalleCompra;
import Formativa2Semana6package.repository.DetalleCompraRepository;

import java.util.Optional;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService{
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public Optional<DetalleCompra> getDetalleCompraById(Long id) {
        return detalleCompraRepository.findById(id);
    }

    @Override
    public DetalleCompra createDetalleCompra(DetalleCompra detalleCompra){
        return detalleCompraRepository.save(detalleCompra);
    }

}