package com.example.tripnaryserver.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.example.tripnaryserver.repository")
public class DynamoConfig {

    @Value("${ENDPOINT_URL}")
    private String endpoint;
    @Value("${REGION_CODE}")
    private String region;
    @Value("${ACCESS_KEY}")
    private String accessKey;
    @Value("${SECRET_KEY}")
    private String secreKey;



    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, region))
                .withCredentials(awsCredentialsProvider()).build();
        return amazonDynamoDB;

    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider(){
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secreKey));
    }

}
