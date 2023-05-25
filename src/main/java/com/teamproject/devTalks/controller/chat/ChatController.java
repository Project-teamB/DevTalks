package com.teamproject.devTalks.controller.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.teamproject.devTalks.repository.chat.ChatMessageRepository;
import com.teamproject.devTalks.repository.chat.ChatRoomRepository;
import com.teamproject.devTalks.service.chat.ChatService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template; 
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatService chatService;

}
    
