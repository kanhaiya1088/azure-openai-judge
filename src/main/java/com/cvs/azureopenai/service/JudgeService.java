package com.cvs.azureopenai.service;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgeService {

    private final OpenAIClient client;

    @Value("${azure.openai.deployment}")
    private String deploymentId;

    public JudgeService(OpenAIClient client) {
        this.client = client;
    }

    public String analyze(String prompt) {
        ChatCompletionsOptions options = new ChatCompletionsOptions(
                List.of(new ChatRequestUserMessage(prompt))
        );

        ChatCompletions response = client.getChatCompletions(deploymentId, options);
        return response.getChoices().get(0).getMessage().getContent();
    }
}