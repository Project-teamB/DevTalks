package com.teamproject.devTalks.service.chat;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatMessageListResponseDto;
import com.teamproject.devTalks.dto.response.ResponseDto;


@Service
public interface ChatService {

    public ResponseEntity<ResponseDto> createChatRoom(Integer userNumber);
    public ResponseEntity<ResponseDto> postChatMessage(Integer chatRoomNumber);
    public ResponseEntity<? super GetChatRoomListResponseDto> getChatRoomList(Integer userNumber);
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(Integer userNumber, String chatRoomNumber);
    public ResponseEntity<ResponseDto> deleteChatRoom(Integer chatRoomNumber);
    public ResponseEntity<ResponseDto> deleteChatMessage(Integer chatRoomNumber, Integer chatMessageNumber);

}
