package com.example.tripnaryserver.service;

import com.example.tripnaryserver.dto.CodigoDefDto;
import com.example.tripnaryserver.dto.UsuarioDefDto;
import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.exception.ErrorMessage;
import com.example.tripnaryserver.repository.CodigoDefRepository;
import com.example.tripnaryserver.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodigoDefService {

    @Autowired
    CodigoDefRepository codigoRepository;

    public Iterable<CodigoDef> lista(){
        return codigoRepository.findAll();
    }

    public CodigoDef getOne(String idCodigo){
        return codigoRepository.findById(idCodigo).get();
    }

    public CodigoDef save(CodigoDefDto dto){
        CodigoDef codigo =
                CodigoDef.builder().codigo(dto.getCodigo()).estado(dto.getEstado())
                        .idUsuario(dto.getIdUsuario())
                        .build();

        return codigoRepository.save(codigo);
    }

    public CodigoDef update(CodigoDefDto dto){
        CodigoDef codigo = codigoRepository.findById(dto.getIdCodigo()).get();
        codigo.setCodigo(dto.getCodigo());
        codigo.setEstado(dto.getEstado());
        codigo.setIdUsuario(dto.getIdUsuario());

        return codigoRepository.save(codigo);
    }

    public void delete(String idCodigo){
        codigoRepository.deleteById(idCodigo);
    }

    public boolean existsId(String idCodigo){
        return codigoRepository.existsById(idCodigo);
    }

    public ErrorMessage getError(int tipo) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setMessageError(tipo);
        return errorMessage;
    }


}
