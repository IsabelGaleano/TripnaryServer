package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.sendgrid.SendEmail;
import com.example.tripnaryserver.service.CodigoDefService;
import com.example.tripnaryserver.service.UsuarioDefService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return new ResponseEntity(usuarioService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.getOne(idUsuario));
    }

    @PostMapping("/usuarioDef")
    public ResponseEntity<UsuarioDef> create(@RequestBody UsuarioDefDto usuarioDto){
        if(usuarioService.existsId(usuarioDto.getCorreoElectronico())){
            return new ResponseEntity(usuarioService.getError(2), HttpStatus.BAD_REQUEST);
        }
        usuarioDto.setContrasenna(usuarioDto.encriptacionMD5Java(usuarioDto.getContrasenna()));
        return ResponseEntity.ok(usuarioService.save(usuarioDto));
    }

    @PutMapping("/usuarioDef")
    public ResponseEntity<UsuarioDef> update(@RequestBody UsuarioDefDto usuarioDto){
        if(!usuarioService.existsId(usuarioDto.getCorreoElectronico()))
            return new ResponseEntity(usuarioService.getError(1), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarioService.update(usuarioDto));
    }

    @DeleteMapping("/usuarioDef/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable("idUsuario") String idUsuario){
        if(!usuarioService.existsId(idUsuario))
            return new ResponseEntity(usuarioService.getError(1), HttpStatus.NOT_FOUND);
        usuarioService.delete(idUsuario);
        return new ResponseEntity(usuarioService.getError(3), HttpStatus.OK);
    }

}
