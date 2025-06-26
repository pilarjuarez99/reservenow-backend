package com.reservenow.repository;

import com.reservenow.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @EntityGraph(attributePaths = {"categoria"})
    List<Product> findAll();

    @EntityGraph(attributePaths = {"categoria"})
    Optional<Product> findById(Long id);

    @EntityGraph(attributePaths = {"categoria"})
    Page<Product> findAll(Pageable pageable);

    // Búsqueda para palabra individual en título o descripción (case-insensitive)
    @EntityGraph(attributePaths = {"categoria"})
    @Query("SELECT p FROM Product p WHERE LOWER(p.titulo) LIKE %:word% OR LOWER(p.descripcion) LIKE %:word%")
    List<Product> searchByWord(@Param("word") String word);

    // Buscar por nombre de categoría
    @EntityGraph(attributePaths = {"categoria"})
    @Query("SELECT p FROM Product p WHERE p.categoria.nombre = :nombre")
    List<Product> findByCategoriaNombre(@Param("nombre") String nombre);
}