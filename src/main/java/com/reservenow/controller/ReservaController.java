package com.reservenow.controller;

import com.reservenow.model.Reserva;
import com.reservenow.model.User;
import com.reservenow.service.ReservaService;
import com.reservenow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createReserva(@RequestBody Reserva reserva) {
        try {
            // Validaciones mínimas de los datos recibidos
            if (reserva.getProduct() == null || reserva.getProduct().getId() == null) {
                return ResponseEntity.badRequest().body("El producto es obligatorio");
            }

            if (reserva.getFechaInicio() == null || reserva.getFechaFin() == null) {
                return ResponseEntity.badRequest().body("Las fechas de inicio y fin son obligatorias");
            }

            if (reserva.getFechaReserva() == null) {
                reserva.setFechaReserva(LocalDateTime.now());
            }

            // Obtener email del usuario autenticado desde el contexto de seguridad
            String email;
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                email = ((UserDetails) principal).getUsername();
            } else {
                email = principal.toString();
            }

            // Buscar usuario por email
            User user = userService.buscarPorEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + email));

            // Asignar usuario autenticado a la reserva
            reserva.setUser(user);

            // Guardar la reserva
            Reserva nuevaReserva = reservaService.create(reserva);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace(); // Útil para depuración
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }
}