package com.example.backend.chatgpt.model;

import java.util.List;

public record ChatGptRequest(
        String model,
        List<ChatGptMessage> messages
) {
}
