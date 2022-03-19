package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.UsuarioDto;
import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<Iterable<Usuario>> list(){
        return ResponseEntity.ok(usuarioService.lista());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Usuario> getOne(@PathVariable("usuarioId") String usuarioId){
        if(!usuarioService.existsId(usuarioId))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.getOne(usuarioId));
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDto usuarioDto){
        if(usuarioService.existsId(usuarioDto.getId()))
            return new ResponseEntity("el id ya existe", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(usuarioService.save(usuarioDto));
    }

    @PutMapping("/usuario")
    public ResponseEntity<Usuario> update(@RequestBody UsuarioDto usuarioDto){
        if(!usuarioService.existsId(usuarioDto.getId()))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.update(usuarioDto));
    }

    @DeleteMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> delete(@PathVariable("usuarioId") String usuarioId){
        if(!usuarioService.existsId(usuarioId))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        usuarioService.delete(usuarioId);
        return new ResponseEntity("usuario eliminado", HttpStatus.OK);
    }


    @GetMapping("/prueba")
    public ResponseEntity<String> prueba(){
        return ResponseEntity.ok("La prueba funciona");
    }


}