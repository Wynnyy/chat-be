package com.patheon.chatty.model.mapper.impl;

import com.patheon.chatty.model.dto.ChatMessageDto;
import com.patheon.chatty.model.entity.ChatMessage;
import com.patheon.chatty.model.mapper.DtoConvertService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChatMessageMapper implements DtoConvertService<ChatMessageDto, ChatMessage> {

    @Override
    public ChatMessageDto toDto(ChatMessage entity) {
        return new ChatMessageDto(
                entity.getId(),
                entity.getCreated(),
                entity.getUpdated(),
                entity.getChatId(),
                entity.getSenderId(),
                entity.getRecipientId(),
                entity.getMessage());
    }

    @Override
    public List<ChatMessageDto> toDto(List<ChatMessage> entity) {
        return entity.stream()
                .map(chatMessage -> toDto(chatMessage))
                .collect(Collectors.toList());
    }
}
