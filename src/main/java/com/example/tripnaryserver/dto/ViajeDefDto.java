package com.example.tripnaryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViajeDefDto {
    private String id_viaje;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String destino;
    private String idUsuario;
    private String estado;
}
