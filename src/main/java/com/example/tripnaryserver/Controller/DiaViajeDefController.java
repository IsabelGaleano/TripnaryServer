package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.Dia_ViajeDefDto;
import com.example.tripnaryserver.entity.Dia_ViajeDef;
import com.example.tripnaryserver.service.Dia_ViajeDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Dia_ViajeDefController {
    @Autowired
    Dia_ViajeDefService dia_viajeService;

    @GetMapping("/dia_viajeDef")
    public ResponseEntity<Iterable<Dia_ViajeDef>> list() {
        return ResponseEntity.ok(dia_viajeService.lista());
    }

    @GetMapping("/dia_viajeDef/{id_dia}")
    public ResponseEntity<Dia_ViajeDef> getOne(@PathVariable("id_dia") String id_dia) {
        if (!dia_viajeService.existsId(id_dia))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dia_viajeService.getOne(id_dia));
    }

    @PostMapping("/dia_viajeDef")
    public ResponseEntity<Dia_ViajeDef> create(@RequestBody Dia_ViajeDefDto dia_viajeDto) {
        if (dia_viajeService.existsId(dia_viajeDto.getId_dia()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(dia_viajeService.save(dia_viajeDto));
    }

    @PutMapping("/dia_viajeDef")
    public ResponseEntity<Dia_ViajeDef> update(@RequestBody Dia_ViajeDefDto dia_viajeDto) {
        if (!dia_viajeService.existsId(dia_viajeDto.getId_dia()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dia_viajeService.update(dia_viajeDto));
    }

    @DeleteMapping("/dia_viajeDef/{id_dia}")
    public ResponseEntity<?> delete(@PathVariable("id_dia") String id_dia) {
        if (!dia_viajeService.existsId(id_dia))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        dia_viajeService.delete(id_dia);
        return new ResponseEntity("Dia del viaje eliminado", HttpStatus.OK);
    }
}
