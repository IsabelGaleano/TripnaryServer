package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.dto.UsuarioDto;
import com.example.tripnaryserver.entity.Direccion;
import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.entity.ViajeDef;
import com.example.tripnaryserver.exception.ErrorMessage;
import com.example.tripnaryserver.repository.UsuarioDefRepository;
import com.example.tripnaryserver.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDefService {
    @Autowired
    UsuarioDefRepository usuarioRepository;

    public Iterable<UsuarioDef> lista(){
        return usuarioRepository.findAll();
    }

    public UsuarioDef getOne(String idUsuario){
        return usuarioRepository.findById(idUsuario).get();
    }

    public UsuarioDef save(UsuarioDefDto dto){
        UsuarioDef usuario =
                UsuarioDef.builder().idUsuario(dto.getCorreoElectronico()).nombre(dto.getNombre())
                        .apellido1(dto.getApellido1()).apellido2(dto.getApellido2()).contrasenna(dto.getContrasenna())
                        .telefono(dto.getTelefono()).estado(dto.getEstado())
                        .build();

        return usuarioRepository.save(usuario);
    }

    public UsuarioDef update(UsuarioDefDto dto){
        UsuarioDef usuario = usuarioRepository.findById(dto.getCorreoElectronico()).get();
        usuario.setIdUsuario(dto.getCorreoElectronico());
        usuario.setNombre(dto.getNombre());
        usuario.setApellido1(dto.getApellido1());
        usuario.setApellido2(dto.getApellido2());
        usuario.setContrasenna(dto.getContrasenna());
        usuario.setTelefono(dto.getTelefono());
        usuario.setEstado(dto.getEstado());

        return usuarioRepository.save(usuario);
    }

    public void delete(String idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }

    public boolean existsId(String idUsuario){
        return usuarioRepository.existsById(idUsuario);
    }

    public boolean existsNombre(String nombre){
        return usuarioRepository.existsByNombre(nombre);
    }

    public ErrorMessage getError(int tipo) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessageError(tipo);
        return errorMessage;
    }

}
