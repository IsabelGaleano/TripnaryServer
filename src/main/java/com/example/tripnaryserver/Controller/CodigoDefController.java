package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.CodigoDefDto;
import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.service.CodigoDefService;
import com.example.tripnaryserver.service.UsuarioDefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CodigoDefController {
    @Autowired
    CodigoDefService codigoService;

    @GetMapping("/codigoDef")
    public ResponseEntity<Iterable<CodigoDef>> list(){
        return ResponseEntity.ok(codigoService.lista());
    }

    @GetMapping("/codigoDef/{idCodigo}")
    public ResponseEntity<CodigoDef> getOne(@PathVariable("idCodigo") String idCodigo){
        if(!codigoService.existsId(idCodigo))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(codigoService.getOne(idCodigo));
    }

    @PostMapping("/codigoDef")
    public ResponseEntity<CodigoDef> create(@RequestBody CodigoDefDto codigoDefDto){
        if(codigoService.existsId(codigoDefDto.getIdCodigo()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(codigoService.save(codigoDefDto));
    }

    @PutMapping("/codigoDef")
    public ResponseEntity<CodigoDef> update(@RequestBody CodigoDefDto codigoDefDto){
        if(!codigoService.existsId(codigoDefDto.getIdCodigo()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(codigoService.update(codigoDefDto));
    }

    @DeleteMapping("/codigoDef/{idCodigo}")
    public ResponseEntity<?> delete(@PathVariable("idCodigo") String idCodigo){
        if(!codigoService.existsId(idCodigo))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        codigoService.delete(idCodigo);
        return new ResponseEntity("codigo eliminado", HttpStatus.OK);
    }
}
