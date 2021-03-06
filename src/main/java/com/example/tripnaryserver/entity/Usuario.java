package com.example.tripnaryserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "usuario")
public class Usuario {

    @DynamoDBAttribute
    String uniqueID = UUID.randomUUID().toString();
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String usuarioId;
    @DynamoDBAttribute
    private String nombre;
    @DynamoDBAttribute
    private Direccion direccion;
}
