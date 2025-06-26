package com.reservenow.controller;

import com.reservenow.model.Favorito;
import com.reservenow.model.User;
import com.reservenow.service.FavoritoService;
import com.reservenow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favService;

    @Autowired
    private UserService userService;

    @PostMapping("/{usuarioEmail}/{productId}")
    public Favorito favoritar(@PathVariable String usuarioEmail, @PathVariable Long productId) {
        User u = userService.buscarPorEmail(usuarioEmail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return favService.mark(u, productId);
    }

    @GetMapping("/{usuarioEmail}")
    public List<Favorito> listar(@PathVariable String usuarioEmail) {
        User u = userService.buscarPorEmail(usuarioEmail)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return favService.listarPorUsuario(u);
    }
}