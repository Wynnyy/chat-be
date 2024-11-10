package com.patheon.chatty.model.dto;

import java.time.LocalDateTime;

public class ChatMessageDto extends BaseEntityDto {

    private String chatId;
    private String senderId;
    private String recipientId;
    private String message;


    public ChatMessageDto(Long id, LocalDateTime created, LocalDateTime updated, String chatId, String senderId, String recipientId, String message) {
        super(id, created, updated);
        this.chatId = chatId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
    }

    public ChatMessageDto() {
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
