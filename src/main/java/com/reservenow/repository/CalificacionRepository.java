package com.reservenow.repository;

import com.reservenow.model.Calificacion;
import com.reservenow.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findByProducto(Product producto);
}