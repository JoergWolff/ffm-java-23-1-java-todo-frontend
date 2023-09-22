package com.example.backend.chatgpt.model;

import java.util.List;

public record ChatGptResponse(
        List<ChatGptResponseChoice> choices
) {
}
