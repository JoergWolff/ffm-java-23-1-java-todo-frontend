package com.example.backend.chatgpt.model;

public record ChatGptMessage(
        String role,
        String content
) {
}
