package com.reservenow.controller;

import com.reservenow.model.Categoria;
import com.reservenow.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired private CategoriaService service;

    @PostMapping public Categoria crear(@RequestBody Categoria c) { return service.crear(c); }

    @GetMapping public List<Categoria> listar() { return service.listar(); }

    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}