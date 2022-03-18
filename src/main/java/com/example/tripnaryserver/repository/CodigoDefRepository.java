package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.CodigoDef;
import com.example.tripnaryserver.entity.UsuarioDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface CodigoDefRepository extends CrudRepository<CodigoDef, String> {
}
