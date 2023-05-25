package com.teamproject.devTalks.service.implement.chat;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatMessageListResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;
import com.teamproject.devTalks.entity.chat.ChatMessageEntity;
import com.teamproject.devTalks.entity.chat.ChatRoomEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatMessageListResultSet;
import com.teamproject.devTalks.entity.resultSet.chat.ChatRoomListResultSet;
import com.teamproject.devTalks.repository.chat.ChatMessageRepository;
import com.teamproject.devTalks.repository.chat.ChatRoomRepository;
import com.teamproject.devTalks.service.chat.ChatService;

import lombok.RequiredArgsConstructor;

@Service
public class ChatServiceImplement implements ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;

    public ChatServiceImplement(ChatRoomRepository chatRoomRepository, ChatMessageRepository chatMessageRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> createChatRoom(Integer userNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createChatRoom'");
    }

    @Override
    public ResponseEntity<ResponseDto> postChatMessage(Integer chatRoomNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postChatMessage'");
    }

    @Override
    public ResponseEntity<? super GetChatRoomListResponseDto> getChatRoomList(Integer userNumber) {
        
        GetChatRoomListResponseDto body = null;
        
        try {        
        // List<ChatRoomListResultSet> resultSet = 
        // ChatRoomRepository.getListOrderBySentDatetimeDesc();
        // body = new GetChatRoomListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(String chatRoomNumber) {     

        if (chatRoomNumber == null) return CustomResponse.validationFailed();
        GetChatMessageListResponseDto body = null;

        try {
            ChatRoomEntity chatRoomEntity = 
            chatRoomRepository.findByChatRoomNumber(chatRoomNumber);
            if(chatRoomEntity == null) return CustomResponse.notExistChatRoomNumber();

            List<ChatMessageListResultSet> resultSet = 
            chatMessageRepository.getListOrderBySentDatetime(chatRoomNumber);

            body = new GetChatMessageListResponseDto(resultSet);

        } catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);    
    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatRoom(Integer chatRoomNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteChatRoom'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatMessage(Integer chatRoomNumber, Integer chatMessageNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteChatMessage'");
    }



}
