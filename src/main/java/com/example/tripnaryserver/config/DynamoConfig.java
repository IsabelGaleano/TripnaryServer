package com.example.tripnaryserver.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.example.tripnaryserver.encriptar.Encriptar;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.tripnaryserver.repository")
public class DynamoConfig {

    @Value("${endpoint}")
    private String endpoint;
    @Value("${region}")
    private String region;

    private String accessKey;
    private String secreKey;
    Encriptar encriptar = new Encriptar();

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .withCredentials(awsCredentialsProvider()).build();
        return amazonDynamoDB;

    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(){
        accessKey = encriptar.desencripta("DNLDWGÑHO2IYNNXFHRXW");
        secreKey = encriptar.desencripta("NlsOhZuBkWXvMwKye6+VKKeRBiVPFu8XoE3Wsy8G");
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secreKey));
    }

}
