package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.dto.ViajeDefDto;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.entity.ViajeDef;
import com.example.tripnaryserver.repository.ViajeDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViajeDefService {
    @Autowired
    ViajeDefRepository viajeRepository;

    public Iterable<ViajeDef> lista(){
        return viajeRepository.findAll();
    }

    public ViajeDef getOne(String idViaje){
        return viajeRepository.findById(String.valueOf(idViaje)).get();
    }

    public ViajeDef save(ViajeDefDto dto){
        ViajeDef viaje =
                ViajeDef.builder().descripcion(dto.getDescripcion())
                        .fechaInicio(dto.getFechaInicio()).fechaFin(dto.getFechaFin()).destino(dto.getDestino())
                        .idUsuario(dto.getIdUsuario()).estado(dto.getEstado())
                        .build();

        return viajeRepository.save(viaje);
    }

    public ViajeDef update(ViajeDefDto dto){
        ViajeDef viaje = viajeRepository.findById(String.valueOf(dto.getId_viaje())).get();
        viaje.setId_viaje(dto.getId_viaje());
        viaje.setDescripcion(dto.getDescripcion());
        viaje.setFechaInicio(dto.getFechaInicio());
        viaje.setFechaFin(dto.getFechaFin());
        viaje.setDestino(dto.getDestino());
        viaje.setIdUsuario(dto.getIdUsuario());
        viaje.setEstado(dto.getEstado());

        return viajeRepository.save(viaje);
    }

    public void delete(String idViaje){
        viajeRepository.deleteById(idViaje);
    }

    public boolean existsId(String idViaje){
        return viajeRepository.existsById(idViaje);
    }

    public boolean existsByIdUsuario(String idUsuario){
        return viajeRepository.existsByIdUsuario(idUsuario);
    }

    public boolean existsByDescripcion(String descripcion){
        return viajeRepository.existsByDescripcion(descripcion);
    }
}
