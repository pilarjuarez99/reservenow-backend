package com.reservenow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "caracteristicas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String iconUrl;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Product> productos;
}