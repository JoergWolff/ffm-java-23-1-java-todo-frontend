package com.example.backend.chatgpt.model;

public record ChatGptResponseMessage(
        String role,
        String content
) {
}
