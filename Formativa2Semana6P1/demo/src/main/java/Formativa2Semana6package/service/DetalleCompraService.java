package Formativa2Semana6package.service;

import java.util.Optional;

import Formativa2Semana6package.model.DetalleCompra;

public interface DetalleCompraService {
    Optional<DetalleCompra> getDetalleCompraById(Long id);
    DetalleCompra createDetalleCompra(DetalleCompra detalleCompra);
}
