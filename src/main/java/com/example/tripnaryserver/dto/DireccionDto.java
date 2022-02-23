package com.example.tripnaryserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDto {
    private String ciudad;
    private String calle;
    private long cp;
}
