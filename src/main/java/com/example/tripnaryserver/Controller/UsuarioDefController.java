package com.example.tripnaryserver.Controller;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.dto.UsuarioDto;
import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.service.UsuarioDefService;
import com.example.tripnaryserver.service.UsuarioService;
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

import java.io.IOException;

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
        usuarioDto.setContrasenna(usuarioDto.encriptacionMD5Java(usuarioDto.getContrasenna()));
        if(usuarioService.existsId(usuarioDto.getCorreoElectronico())){
            return new ResponseEntity(usuarioService.getError(2), HttpStatus.BAD_REQUEST);
        }
        Email from = new Email("david@rodriguezcoto.com");
        String subject = "Prueba";
        Email to = new Email(usuarioDto.getCorreoElectronico());
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
