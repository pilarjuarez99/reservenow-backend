package com.reservenow.service;

import com.reservenow.model.Reserva;
import com.reservenow.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva create(Reserva reserva) {
        if (reserva.getFechaReserva() == null) {
            reserva.setFechaReserva(LocalDateTime.now());
        }

        // Validar fechas
        if (reserva.getFechaInicio() == null || reserva.getFechaFin() == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son obligatorias.");
        }

        if (reserva.getFechaFin().isBefore(reserva.getFechaInicio())) {
            throw new IllegalArgumentException("La fecha de fin debe ser posterior a la fecha de inicio.");
        }

        // Validar solapamiento con reservas existentes para el mismo producto
        List<Reserva> reservasExistentes = reservaRepository.findAll();

        boolean solapa = reservasExistentes.stream().anyMatch(r ->
            r.getProduct().getId().equals(reserva.getProduct().getId()) &&
            !(reserva.getFechaFin().isBefore(r.getFechaInicio()) || reserva.getFechaInicio().isAfter(r.getFechaFin()))
        );

        if (solapa) {
            throw new IllegalStateException("Las fechas seleccionadas no están disponibles para este producto.");
        }

        return reservaRepository.save(reserva);
    }
}
