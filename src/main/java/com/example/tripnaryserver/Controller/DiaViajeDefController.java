package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.DiaViajeDefDto;
import com.example.tripnaryserver.entity.DiaViajeDef;
import com.example.tripnaryserver.service.DiaViajeDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class DiaViajeDefController {
    @Autowired
    DiaViajeDefService dia_viajeService;

    @GetMapping("/dia_viajeDef")
    public ResponseEntity<Iterable<DiaViajeDef>> list() {
        return ResponseEntity.ok(dia_viajeService.lista());
    }

    @GetMapping("/dia_viajeDef/{id_dia}")
    public ResponseEntity<DiaViajeDef> getOne(@PathVariable("id_dia") String id_dia) {
        if (!dia_viajeService.existsId(id_dia))
            return new ResponseEntity(dia_viajeService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dia_viajeService.getOne(id_dia));
    }

    @PostMapping("/dia_viajeDef")
    public ResponseEntity<DiaViajeDef> create(@RequestBody DiaViajeDefDto dia_viajeDto) {
        if (dia_viajeService.existsId(dia_viajeDto.getId_dia()))
            return new ResponseEntity(dia_viajeService.getError(2), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(dia_viajeService.save(dia_viajeDto));
    }

    @PutMapping("/dia_viajeDef")
    public ResponseEntity<DiaViajeDef> update(@RequestBody DiaViajeDefDto dia_viajeDto) {
        if (!dia_viajeService.existsId(dia_viajeDto.getId_dia()))
            return new ResponseEntity(dia_viajeService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dia_viajeService.update(dia_viajeDto));
    }

    @DeleteMapping("/dia_viajeDef/{id_dia}")
    public ResponseEntity<?> delete(@PathVariable("id_dia") String id_dia) {
        if (!dia_viajeService.existsId(id_dia))
            return new ResponseEntity(dia_viajeService.getError(1), HttpStatus.NOT_FOUND);
        dia_viajeService.delete(id_dia);
        return new ResponseEntity(dia_viajeService.getError(3), HttpStatus.OK);
    }
}
