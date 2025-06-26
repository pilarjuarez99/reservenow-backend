package com.reservenow.service;

import com.reservenow.model.Favorito;
import com.reservenow.model.Product;
import com.reservenow.model.User;
import com.reservenow.repository.FavoritoRepository;
import com.reservenow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    @Autowired
    private ProductRepository productRepository;

    public Favorito mark(User usuario, Long productoId) {
        Product producto = productRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Favorito f = new Favorito();
        f.setUsuario(usuario);
        f.setProducto(producto);
        return favoritoRepository.save(f);
    }

    public List<Favorito> listarPorUsuario(User usuario) {
        return favoritoRepository.findByUsuario(usuario);
    }
}
