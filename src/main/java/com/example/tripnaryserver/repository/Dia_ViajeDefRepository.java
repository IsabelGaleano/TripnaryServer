package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.Dia_ViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface Dia_ViajeDefRepository extends CrudRepository<Dia_ViajeDef, String> {
    boolean existsByNombre(String nombre);
}
