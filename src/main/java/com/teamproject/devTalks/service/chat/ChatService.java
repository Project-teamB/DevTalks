package com.teamproject.devTalks.service.chat;

import org.springframework.http.ResponseEntity;

import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;

public interface ChatService {
    
    public ResponseEntity<? super GetChatRoomListResponseDto> getChatRoomList();
}
