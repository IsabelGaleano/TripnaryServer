package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.dto.ViajeDefDto;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.entity.ViajeDef;
import com.example.tripnaryserver.service.UsuarioDefService;
import com.example.tripnaryserver.service.ViajeDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ViajeDefController {

    @Autowired
    ViajeDefService viajeService;

    @GetMapping("/viajesDef")
    public ResponseEntity<Iterable<ViajeDef>> list(){
        return ResponseEntity.ok(viajeService.lista());
    }

    @GetMapping("/viajeDef/{idViaje}")
    public ResponseEntity<ViajeDef> getOne(@PathVariable("idViaje") String idViaje){
        if(!viajeService.existsId(String.valueOf(idViaje)))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(viajeService.getOne(idViaje));
    }

    @PostMapping("/viajeDef")
    public ResponseEntity<ViajeDef> create(@RequestBody ViajeDefDto viajeDto){
        if(viajeService.existsId(viajeDto.getId_viaje()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(viajeService.save(viajeDto));
    }

    @PutMapping("/viajeDef")
    public ResponseEntity<ViajeDef> update(@RequestBody ViajeDefDto viajeDto){
        if(!viajeService.existsId(String.valueOf(viajeDto.getId_viaje())))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(viajeService.update(viajeDto));
    }

    @DeleteMapping("/viajeDef/{idViaje}")
    public ResponseEntity<?> delete(@PathVariable("idViaje") String idViaje){
        if(!viajeService.existsId(idViaje))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        viajeService.delete(idViaje);
        return new ResponseEntity("viaje eliminado", HttpStatus.OK);
    }

}
