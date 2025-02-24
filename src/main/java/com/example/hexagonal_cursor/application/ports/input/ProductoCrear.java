package com.example.hexagonal_cursor.application.ports.input;

import com.example.hexagonal_cursor.domain.model.Producto;

public interface ProductoCrear {
    Producto crearProducto(Producto producto);
}
