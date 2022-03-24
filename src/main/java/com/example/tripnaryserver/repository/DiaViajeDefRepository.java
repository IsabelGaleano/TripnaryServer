package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.DiaViajeDef;
import com.example.tripnaryserver.entity.ViajeDef;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableScan
@Repository
public interface DiaViajeDefRepository extends CrudRepository<DiaViajeDef, String> {

}
