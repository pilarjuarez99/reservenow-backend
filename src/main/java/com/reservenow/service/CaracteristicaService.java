package com.reservenow.service;

import com.reservenow.model.Caracteristica;
import com.reservenow.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaracteristicaService {

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;

    public List<Caracteristica> listAll() {
        return caracteristicaRepository.findAll();
    }

    public Caracteristica create(Caracteristica c) {
        return caracteristicaRepository.save(c);
    }

    public void delete(Long id) {
        if (!caracteristicaRepository.existsById(id)) {
            throw new RuntimeException("Caracteristica no encontrada con id: " + id);
        }
        caracteristicaRepository.deleteById(id);
    }
}