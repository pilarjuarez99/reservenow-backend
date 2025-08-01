package com.reservenow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @ManyToMany(mappedBy = "caracteristicas", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Product> productos;
}
