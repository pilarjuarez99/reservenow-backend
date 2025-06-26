package com.reservenow.controller;

import com.reservenow.model.Caracteristica;
import com.reservenow.service.CaracteristicaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/caracteristicas")
public class CaracteristicaController {
    @Autowired private CaracteristicaService service;

    @PostMapping public Caracteristica crear(@RequestBody Caracteristica c) { return service.create(c); }

    @GetMapping public List<Caracteristica> listar() { return service.listAll(); }

    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.delete(id); }
}