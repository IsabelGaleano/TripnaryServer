package com.example.tripnaryserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "usuarios")
public class UsuarioDef {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String idUsuario;

    @DynamoDBAttribute
    private String nombre;

    @DynamoDBAttribute
    private String apellido1;

    @DynamoDBAttribute
    private String apellido2;

    @DynamoDBAttribute
    private String contrasenna;

    @DynamoDBAttribute
    private String telefono;

    @DynamoDBAttribute
    private String estado;
}
