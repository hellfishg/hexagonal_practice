package com.example.hexagonal_cursor.application.ports.input;

import com.example.hexagonal_cursor.domain.model.Producto;

public interface ProductoObtener {
    Producto obtenerProducto(Long id);
} 