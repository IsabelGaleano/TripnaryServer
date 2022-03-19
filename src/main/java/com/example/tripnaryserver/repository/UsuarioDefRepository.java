package com.example.tripnaryserver.repository;

import com.example.tripnaryserver.entity.Usuario;
import com.example.tripnaryserver.entity.UsuarioDef;
import com.example.tripnaryserver.exception.ErrorMessage;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface UsuarioDefRepository extends CrudRepository<UsuarioDef, String> {
    boolean existsByNombre(String nombre);

}
