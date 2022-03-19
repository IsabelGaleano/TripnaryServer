package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.dto.UsuarioDto;
import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.service.UsuarioDefService;
import com.example.tripnaryserver.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UsuarioDefController {

    @Autowired
    UsuarioDefService usuarioService;
    @CrossOrigin
    @GetMapping("/usuarioDef")
    public ResponseEntity<Iterable<UsuarioDef>> list(){
        return ResponseEntity.ok(usuarioService.lista());
    }

    @GetMapping("/usuarioDef/{idUsuario}")
    public ResponseEntity<UsuarioDef> getOne(@PathVariable("idUsuario") String idUsuario){
        if(!usuarioService.existsId(idUsuario))
            return new ResponseEntity(usuarioService.getError(), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.getOne(idUsuario));
    }

    @PostMapping("/usuarioDef")
    public ResponseEntity<UsuarioDef> create(@RequestBody UsuarioDefDto usuarioDto){
        if(usuarioService.existsId(usuarioDto.getCorreoElectronico()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(usuarioService.save(usuarioDto));
    }

    @PutMapping("/usuarioDef")
    public ResponseEntity<UsuarioDef> update(@RequestBody UsuarioDefDto usuarioDto){
        if(!usuarioService.existsId(usuarioDto.getCorreoElectronico()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.update(usuarioDto));
    }

    @DeleteMapping("/usuarioDef/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable("idUsuario") String idUsuario){
        if(!usuarioService.existsId(idUsuario))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        usuarioService.delete(idUsuario);
        return new ResponseEntity("usuario eliminado", HttpStatus.OK);
    }

}
