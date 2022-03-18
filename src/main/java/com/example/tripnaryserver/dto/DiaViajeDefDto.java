package com.example.tripnaryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DiaViajeDefDto {
    private String id_dia;
    private Date fecha_dia;
    private String comentarios;
    private String id_viaje;
    private String estado;
}
