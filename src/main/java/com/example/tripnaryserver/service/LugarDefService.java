package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.LugarDefDto;
import com.example.tripnaryserver.entity.LugarDef;
import com.example.tripnaryserver.repository.LugarDefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LugarDefService {
    @Autowired
    LugarDefRepository lugarRepository;
    public Iterable<LugarDef> lista(){
        return lugarRepository.findAll();
    }

    public LugarDef getOne(String id_lugar){
        return lugarRepository.findById(id_lugar).get();
    }

    public LugarDef save(LugarDefDto dto){
        LugarDef lugar =
                LugarDef.builder().nombre(dto.getNombre())
                        .hora(dto.getHora()).comentarios(dto.getComentarios()).id_dia(dto.getId_dia())
                        .estado(dto.getEstado())
                        .build();

        return lugarRepository.save(lugar);
    }

    public LugarDef update(LugarDefDto dto){
        LugarDef lugar = lugarRepository.findById(dto.getId_lugar()).get();
        lugar.setId_lugar(dto.getId_lugar());
        lugar.setNombre(dto.getNombre());
        lugar.setHora(dto.getHora());
        lugar.setComentarios(dto.getComentarios());
        lugar.setId_dia(dto.getId_dia());
        lugar.setEstado(dto.getEstado());

        return lugarRepository.save(lugar);
    }

    public void delete(String id_lugar){
        lugarRepository.deleteById(id_lugar);
    }

    public boolean existsId(String id_lugar){
        return lugarRepository.existsById(id_lugar);
    }

    public boolean existsNombre(String nombre){
        return lugarRepository.existsByNombre(nombre);
    }
}
