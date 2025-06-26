package com.reservenow.service;

import com.reservenow.model.Calificacion;
import com.reservenow.model.Product;
import com.reservenow.repository.CalificacionRepository;
import com.reservenow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository repo;

    @Autowired
    private ProductRepository productRepository;

    public Calificacion crear(Calificacion c) {
        return repo.save(c);
    }

    public List<Calificacion> listarPorProducto(Long pId) {
        Product product = productRepository.findById(pId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + pId));
        return repo.findByProducto(product);
    }
}