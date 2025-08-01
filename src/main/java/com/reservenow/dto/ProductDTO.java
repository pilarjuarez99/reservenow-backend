package com.reservenow.dto;

import java.util.Set;

public class ProductDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String imagenUrl;
    private String categoria;
    private Set<String> imagenes;
    private Set<String> caracteristicas;
    private Set<String> fechasDisponibles;
    private String ubicacion;

    // Constructor completo
    public ProductDTO(Long id, String titulo, String descripcion, String imagenUrl,
                      String categoria, Set<String> imagenes, Set<String> caracteristicas,
                      Set<String> fechasDisponibles, String ubicacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
        this.categoria = categoria;
        this.imagenes = imagenes;
        this.caracteristicas = caracteristicas;
        this.fechasDisponibles = fechasDisponibles;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Set<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(Set<String> imagenes) {
        this.imagenes = imagenes;
    }

    public Set<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Set<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Set<String> getFechasDisponibles() {
        return fechasDisponibles;
    }

    public void setFechasDisponibles(Set<String> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}