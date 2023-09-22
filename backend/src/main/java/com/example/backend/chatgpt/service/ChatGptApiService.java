package com.example.backend.chatgpt.service;

import com.example.backend.chatgpt.model.ChatGptMessage;
import com.example.backend.chatgpt.model.ChatGptRequest;
import com.example.backend.chatgpt.model.ChatGptResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ChatGptApiService {

    @Value("${chatGptApiKey}")
    private String apiKey;
    @Value("${chatGptApiGroup}")
    private String apiGroup;
    private final String questionAddon = "Bitte folgenden Text in Deutsch auf Rechtschreibung und Grammatik prüfen und die korrigierte Fassung als Antwort ohne zusätzlichen Text zurückgeben: ";

    public String askChatGpt(String question) throws NullPointerException {
        WebClient webClient = WebClient.create();

        ChatGptRequest request = new ChatGptRequest("gpt-3.5-turbo", List.of(new ChatGptMessage("user", questionAddon + question)));

        ChatGptResponse chatGptResponse =
                webClient.post()
                        .uri("https://api.openai.com/v1/chat/completions")
                        .header("Authorization", "Bearer " + apiKey)
                        .header("OpenAI-Organization", apiGroup)
                        .bodyValue(request)
                        .retrieve()
                        .toEntity(ChatGptResponse.class)
                        .block()
                        .getBody();

        return chatGptResponse.choices().get(0).message().content();
    }
}
