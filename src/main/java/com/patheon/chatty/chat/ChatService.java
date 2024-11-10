package com.patheon.chatty.chat;

import com.patheon.chatty.model.dto.ChatMessageDto;
import com.patheon.chatty.model.entity.ChatMessage;

public interface ChatService {

    ChatMessageDto send(ChatMessage chatMessage);
}
