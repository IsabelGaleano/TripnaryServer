package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.Dia_ViajeDefDto;
import com.example.tripnaryserver.entity.Dia_ViajeDef;
import com.example.tripnaryserver.repository.Dia_ViajeDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dia_ViajeDefService {
    @Autowired
    Dia_ViajeDefRepository dia_viajeRepository;

    public Iterable<Dia_ViajeDef> lista() {
        return dia_viajeRepository.findAll();
    }

    public Dia_ViajeDef getOne(String id_dia) {
        return dia_viajeRepository.findById(id_dia).get();
    }

    public Dia_ViajeDef save(Dia_ViajeDefDto dto) {
        Dia_ViajeDef dia_viaje =
                Dia_ViajeDef.builder().id_dia("").fecha_dia(dto.getFecha_dia())
                        .comentarios(dto.getComentarios()).id_viaje(dto.getId_viaje())
                        .estado(dto.getEstado())
                        .build();

        return dia_viajeRepository.save(dia_viaje);
    }

    public Dia_ViajeDef update(Dia_ViajeDefDto dto) {
        Dia_ViajeDef dia_viaje = dia_viajeRepository.findById(dto.getId_dia()).get();
        dia_viaje.setId_dia(dto.getId_dia());
        dia_viaje.setFecha_dia(dto.getFecha_dia());
        dia_viaje.setComentarios(dto.getComentarios());
        dia_viaje.setId_viaje(dto.getId_viaje());
        dia_viaje.setEstado(dto.getEstado());

        return dia_viajeRepository.save(dia_viaje);
    }

    public void delete(String id_dia) {
        dia_viajeRepository.deleteById(id_dia);
    }

    public boolean existsId(String id_dia) {
        return dia_viajeRepository.existsById(id_dia);
    }

    public boolean existsNombre(String nombre) {
        return dia_viajeRepository.existsByNombre(nombre);
    }
}
