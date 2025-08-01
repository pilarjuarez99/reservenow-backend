package com.reservenow.repository;

import com.reservenow.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    // Método para buscar imágenes por producto
    List<Image> findByProductId(Long productId);
}