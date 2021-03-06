package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.ViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface ViajeDefRepository extends CrudRepository<ViajeDef, String> {
    public List<ViajeDef> findViajeDefByIdUsuario(String idUsuario);
}
