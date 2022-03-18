package com.example.tripnaryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LugarDefDto {
    private String id_lugar;
    private String nombre;
    private Date hora;
    private String comentarios;
    private String id_dia;
    private String estado;
}
