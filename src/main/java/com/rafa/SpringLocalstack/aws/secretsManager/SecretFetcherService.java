package com.rafa.SpringLocalstack.aws.secretsManager;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretFetcherService {
    private @Value("${spring.aws.secretsmanager.endpoint}") String endpoint;
    private @Value("${spring.aws.secretsmanager.region}") String region;

    public String fetch(String secretName) {
        return this.getSecretValueString(secretName);  
    }

    private String getSecretValueString(String secretName) {
        GetSecretValueRequest secretId = new GetSecretValueRequest().withSecretId(secretName); 
        GetSecretValueResult secretValue = this.buildAWSClient().getSecretValue(secretId);
        return secretValue.getSecretString();
    }

    private AWSSecretsManager buildAWSClient() {
        AWSSecretsManagerClientBuilder clientBuilder = AWSSecretsManagerClientBuilder.standard();
        clientBuilder.setEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration(endpoint, region)
        );
        return clientBuilder.build();
    }
}
