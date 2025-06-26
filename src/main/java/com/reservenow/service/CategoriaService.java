package com.reservenow.service;

import com.reservenow.model.Categoria;
import com.reservenow.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria crear(Categoria c) {
        return repo.save(c);
    }

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }
        repo.deleteById(id);
    }

    public Optional<Categoria> findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public Categoria save(Categoria categoria) {
        return repo.save(categoria);
    }
}