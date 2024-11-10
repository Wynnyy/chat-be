package com.patheon.chatty.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chat_message")
public class ChatMessage extends BaseEntity {

    @Column(name = "chat_id", nullable = false, updatable = false)
    private String chatId;
    @Column(name = "sender_id", nullable = false, updatable = false)
    private String senderId;
    @Column(name = "recipient_id", nullable = false, updatable = false)
    private String recipientId;
    @Column(name = "message", nullable = false, updatable = false)
    private String message;

    public ChatMessage() {
    }

    public ChatMessage(Long id, LocalDateTime created, LocalDateTime updated, String chatId, String senderId, String recipientId, String message) {
        super(id, created, updated);
        this.chatId = chatId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ChatMessage that = (ChatMessage) o;

        if (!Objects.equals(chatId, that.chatId)) return false;
        if (!Objects.equals(senderId, that.senderId)) return false;
        if (!Objects.equals(recipientId, that.recipientId)) return false;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chatId != null ? chatId.hashCode() : 0);
        result = 31 * result + (senderId != null ? senderId.hashCode() : 0);
        result = 31 * result + (recipientId != null ? recipientId.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "chatId='" + chatId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", recipientId='" + recipientId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
