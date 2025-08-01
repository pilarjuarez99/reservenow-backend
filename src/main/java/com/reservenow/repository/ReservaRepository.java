package com.reservenow.repository;

import com.reservenow.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Método para obtener reservas por el ID del producto
    List<Reserva> findByProductId(Long productId);
}