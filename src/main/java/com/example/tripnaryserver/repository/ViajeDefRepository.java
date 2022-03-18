package com.example.tripnaryserver.repository;


import com.example.tripnaryserver.entity.ViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ViajeDefRepository extends CrudRepository<ViajeDef, String> {
    boolean existsByDescripcion(String id);
    boolean existsByIdUsuario(String id);
}