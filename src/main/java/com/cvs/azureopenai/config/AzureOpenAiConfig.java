package com.cvs.azureopenai.config;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureOpenAiConfig {

    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${azure.openai.tenant-id}")
    private String tenantId;

    @Value("${azure.openai.client-id}")
    private String clientId;

    @Value("${azure.openai.client-secret}")
    private String clientSecret;

    @Bean
    public OpenAIClient openAIClient() {
        ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .tenantId(tenantId)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .build();

        return new OpenAIClientBuilder()
                .endpoint(endpoint)
                .credential(credential)
                .buildClient();
    }
}