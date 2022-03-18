package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.DiaViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DiaViajeDefRepository extends CrudRepository<DiaViajeDef, String> {

}
