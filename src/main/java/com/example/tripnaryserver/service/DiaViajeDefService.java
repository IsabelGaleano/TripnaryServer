package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.DiaViajeDefDto;
import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.DiaViajeDef;
import com.example.tripnaryserver.repository.DiaViajeDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaViajeDefService {
    @Autowired
    DiaViajeDefRepository dia_viajeRepository;

    public Iterable<DiaViajeDef> lista() {
        return dia_viajeRepository.findAll();
    }

    public DiaViajeDef getOne(String id_dia) {
        return dia_viajeRepository.findById(id_dia).get();
    }

    public DiaViajeDef save(DiaViajeDefDto dto) {
        DiaViajeDef dia_viaje =
                DiaViajeDef.builder().fecha_dia(dto.getFecha_dia())
                        .comentarios(dto.getComentarios()).id_viaje(dto.getId_viaje())
                        .estado(dto.getEstado())
                        .build();

        return dia_viajeRepository.save(dia_viaje);
    }

    public DiaViajeDef update(DiaViajeDefDto dto) {
        DiaViajeDef dia_viaje = dia_viajeRepository.findById(dto.getId_dia()).get();
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


}
