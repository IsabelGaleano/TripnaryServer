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
@DynamoDBTable(tableName = "codigos")
public class CodigoDef {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String idCodigo;

    @DynamoDBAttribute
    private int codigo;

    @DynamoDBAttribute
    private String estado;

    @DynamoDBAttribute
    private String idUsuario;

}