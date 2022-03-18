package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.LugarDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface LugarDefRepository extends CrudRepository<LugarDef, String> {
    boolean existsByNombre(String nombre);
}
