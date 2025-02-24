package com.example.hexagonal_cursor.infrastructure.input;

import com.example.hexagonal_cursor.application.ports.input.ProductoCrear;
import com.example.hexagonal_cursor.application.ports.input.ProductoObtener;
import com.example.hexagonal_cursor.application.ports.input.ProductoActualizar;
import com.example.hexagonal_cursor.domain.model.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoCrear crearProducto;
    private final ProductoObtener obtenerProducto;
    private final ProductoActualizar actualizarProducto;
    
    public ProductoController(
            ProductoCrear crearProducto, 
            ProductoObtener obtenerProducto, 
            ProductoActualizar actualizarProducto) {
        this.crearProducto = crearProducto;
        this.obtenerProducto = obtenerProducto;
        this.actualizarProducto = actualizarProducto;
    }

    @PostMapping("/crear")
    public Producto crearProducto(@RequestBody Producto producto) {
        return crearProducto.crearProducto(producto);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return obtenerProducto.obtenerProducto(id);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable Long id, 
            @RequestBody Producto producto) {
        return actualizarProducto.actualizarProducto(id, producto);
    }

    // Demo de endpoint
    @GetMapping("test")
    public String getMethodName() {
        return "Hola Mundo";
    }
    
}
