package com.teamproject.devTalks.service.implement.chat;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.dto.request.chat.CreateChatMessageRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;
import com.teamproject.devTalks.service.chat.ChatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatServiceImplement implements ChatService {
    
    @Override
    public ResponseEntity<? super GetChatRoomListResponseDto> getChatRoomList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getChatRoomList'");
    }



}
