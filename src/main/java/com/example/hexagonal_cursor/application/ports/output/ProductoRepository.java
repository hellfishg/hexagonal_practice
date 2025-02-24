package com.example.hexagonal_cursor.application.ports.output;

import com.example.hexagonal_cursor.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // (findById, save, deleteById) implementadas por JpaRepository
}
