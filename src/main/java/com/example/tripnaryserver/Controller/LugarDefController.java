package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.LugarDefDto;
import com.example.tripnaryserver.entity.LugarDef;
import com.example.tripnaryserver.service.LugarDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LugarDefController {
    @Autowired
    LugarDefService lugarService;

    @GetMapping("/lugarDef")
    public ResponseEntity<Iterable<LugarDef>> list(){
        return ResponseEntity.ok(lugarService.lista());
    }

    @GetMapping("/lugarDef/{id_lugar}")
    public ResponseEntity<LugarDef> getOne(@PathVariable("id_lugar") String id_lugar){
        if(!lugarService.existsId(id_lugar))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(lugarService.getOne(id_lugar));
    }

    @PostMapping("/lugarDef")
    public ResponseEntity<LugarDef> create(@RequestBody LugarDefDto lugarDto){
        if(lugarService.existsId(lugarDto.getId_lugar()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(lugarService.save(lugarDto));
    }

    @PutMapping("/lugarDef")
    public ResponseEntity<LugarDef> update(@RequestBody LugarDefDto lugarDto){
        if(!lugarService.existsId(lugarDto.getId_lugar()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(lugarService.update(lugarDto));
    }

    @DeleteMapping("/lugarDef/{id_lugar}")
    public ResponseEntity<?> delete(@PathVariable("id_lugar") String id_lugar){
        if(!lugarService.existsId(id_lugar))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        lugarService.delete(id_lugar);
        return new ResponseEntity("lugar eliminado", HttpStatus.OK);
    }
}
