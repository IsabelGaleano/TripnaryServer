package com.example.tripnaryserver.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "lugares")
public class LugarDef {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id_lugar;

    @DynamoDBAttribute
    private String nombre;

    @DynamoDBAttribute
    private Date hora;

    @DynamoDBAttribute
    private String comentarios;

    @DynamoDBAttribute
    private String id_dia;

    @DynamoDBAttribute
    private String estado;
}