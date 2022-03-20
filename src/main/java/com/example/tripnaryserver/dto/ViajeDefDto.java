package com.example.tripnaryserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViajeDefDto {

    private String idViaje;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String destino;
    private String idUsuario;
    private String estado;
}
