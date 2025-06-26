package com.reservenow.controller;

import com.reservenow.model.Calificacion;
import com.reservenow.service.CalificacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {
    @Autowired private CalificacionService service;

    @PostMapping public Calificacion crear(@RequestBody Calificacion c) { return service.crear(c); }

    @GetMapping("/producto/{productId}")
    public List<Calificacion> listarPorProducto(@PathVariable Long productId) {
        return service.listarPorProducto(productId);
    }
}