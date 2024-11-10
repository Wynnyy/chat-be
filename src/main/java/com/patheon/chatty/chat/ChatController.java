package com.patheon.chatty.chat;

import com.patheon.chatty.model.dto.ChatMessageDto;
import com.patheon.chatty.model.entity.ChatMessage;
import com.patheon.chatty.model.entity.ChatNotification;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ChatController {

    private final ChatService chatService;

    private final SimpMessagingTemplate messagingTemplate;


    public ChatController(ChatServiceImpl chatService, SimpMessagingTemplate messagingTemplate) {
        this.chatService = chatService;
        this.messagingTemplate = messagingTemplate;
    }

//    @GetMapping("/chat/{senderId}/{recipientId}")
//    public List<ChatMessage> getChatMessage(
//            @PathVariable("senderId") String senderId,
//            @PathVariable("recipientId") String recipientId) {
//        return null;
//       // return chatRepository.findAllById(1L);
//    }
@GetMapping("/chatInfo")
public String getChatMessage() {
    return "info chat";
    // return chatRepository.findAllById(1L);
}
//
//    @MessageMapping("/chat")
//    public void processMessage(@Payload ChatMessage chatMessage) {
//        //ChatMessage savedMsg = chatRepository.save(chatMessage);
//        ChatMessage savedMsg = null;
//        messagingTemplate.convertAndSendToUser(
//                chatMessage.getRecipientId(), "/queue/messages",
//                new ChatNotification(
//                        savedMsg.getId(),
//                        savedMsg.getSenderId(),
//                        savedMsg.getRecipientId(),
//                        savedMsg.getMessage()
//                )
//        );
//    }

    @MessageMapping("/send/{room}")
    @SendTo("/topic/message")
    public ChatMessageDto sendMessage(@DestinationVariable String room, @Payload ChatMessage chatMessage){
        System.out.println("CALLING METHOD " +chatMessage.toString());
        return chatService.send(chatMessage);
    }

    @SubscribeMapping("/send/{room}")
    public ChatMessageDto getMessageFromRoom(@DestinationVariable String room, @Payload ChatMessage chatMessage){
        System.out.println("CALLING METHOD " +chatMessage.toString());
        return chatService.send(chatMessage);
    }


    @MessageMapping("/chat.addUser")
    @SendTo("/topic")
    public ChatMessage addUser(@Payload ChatMessage chatMessage){

        return chatMessage;
    }


}

