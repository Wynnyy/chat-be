package com.patheon.chatty.chat;

import com.patheon.chatty.model.dto.ChatMessageDto;
import com.patheon.chatty.model.entity.ChatMessage;
import com.patheon.chatty.model.mapper.impl.ChatMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatMessageMapper chatMessageMapper;

    @Autowired
    public ChatServiceImpl(ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
    }


    @Override
    public ChatMessageDto send(ChatMessage chatMessage) {
        return chatMessageMapper.toDto(chatMessage);
    }
}
