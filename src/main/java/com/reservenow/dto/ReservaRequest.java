package com.reservenow.dto;

import java.time.LocalDate;

public class ReservaRequest {

    private Long productId;
    private String userEmail;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String comentarios; // opcional

    public ReservaRequest() {}

    public ReservaRequest(Long productId, String userEmail, LocalDate fechaInicio, LocalDate fechaFin, String comentarios) {
        this.productId = productId;
        this.userEmail = userEmail;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.comentarios = comentarios;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}