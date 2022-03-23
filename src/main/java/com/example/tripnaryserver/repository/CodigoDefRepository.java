package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.entity.ViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface CodigoDefRepository extends CrudRepository<CodigoDef, String> {
    public List<CodigoDef> findCodigoDefByIdUsuario(String idUsuario);
}
