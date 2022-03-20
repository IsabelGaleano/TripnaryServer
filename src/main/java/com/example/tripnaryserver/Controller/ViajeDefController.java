package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.ViajeDefDto;
import com.example.tripnaryserver.entity.ViajeDef;
import com.example.tripnaryserver.service.ViajeDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ViajeDefController {
    @Autowired
    ViajeDefService viajeService;
    @CrossOrigin
    @GetMapping("/viajeDef")
    public ResponseEntity<Iterable<ViajeDef>> list(){
        return ResponseEntity.ok(viajeService.lista());
    }

    @GetMapping("/viajeDef/{idViaje}")
    public ResponseEntity<ViajeDef> getOne(@PathVariable("idViaje") String idViaje){
        if(!viajeService.existsId(idViaje))
            return new ResponseEntity(viajeService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(viajeService.getOne(idViaje));
    }

    @PostMapping("/viajeDef")
    public ResponseEntity<ViajeDef> create(@RequestBody ViajeDefDto viajeDto){
        if(viajeService.existsId(viajeDto.getIdViaje()))
            return new ResponseEntity(viajeService.getError(2), HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(viajeService.save(viajeDto));
    }

    @PutMapping("/viajeDef")
    public ResponseEntity<ViajeDef> update(@RequestBody ViajeDefDto viajeDto){
        if(!viajeService.existsId(viajeDto.getIdViaje()))
            return new ResponseEntity(viajeService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(viajeService.update(viajeDto));
    }

    @DeleteMapping("/viajeDef/{idViaje}")
    public ResponseEntity<?> delete(@PathVariable("idViaje") String idViaje){
        if(!viajeService.existsId(idViaje))
            return new ResponseEntity(viajeService.getError(1), HttpStatus.NOT_FOUND);
        viajeService.delete(idViaje);
        return new ResponseEntity(viajeService.getError(3), HttpStatus.OK);
    }
}
