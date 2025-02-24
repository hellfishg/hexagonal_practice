package com.example.hexagonal_cursor.application.ports.services;

import com.example.hexagonal_cursor.application.ports.input.ProductoCrear;
import com.example.hexagonal_cursor.application.ports.input.ProductoObtener;

import org.springframework.stereotype.Service;

import com.example.hexagonal_cursor.application.ports.input.ProductoActualizar;
import com.example.hexagonal_cursor.application.ports.input.ProductoBorrar;
import com.example.hexagonal_cursor.application.ports.output.ProductoRepository;
import com.example.hexagonal_cursor.domain.model.Producto;
import com.example.hexagonal_cursor.domain.exception.ProductoNotFoundException;

@Service
public class ProductoService implements ProductoCrear, ProductoObtener, ProductoActualizar, ProductoBorrar {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProducto(Long id) {
        validarID(id);
        return productoRepository.findById(id)
            .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        validarID(id);
        Producto productoExistente = obtenerProducto(id);
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        return productoRepository.save(productoExistente);
    }

    @Override
    public void borrarProducto(Long id) {
        validarID(id);
        obtenerProducto(id);
        productoRepository.deleteById(id);
    }

    private void validarID(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del producto no puede ser nulo");
        }
    }

}
