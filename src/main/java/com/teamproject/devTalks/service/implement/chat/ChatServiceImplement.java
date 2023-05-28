package com.teamproject.devTalks.service.implement.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.chat.PostChatMessageDto;
import com.teamproject.devTalks.dto.request.chat.PostChatRoomDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatMessageListResponseDto;
import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;
import com.teamproject.devTalks.entity.chat.ChatMessageEntity;
import com.teamproject.devTalks.entity.chat.ChatRoomEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatMessageListResultSet;
import com.teamproject.devTalks.entity.resultSet.chat.ChatRoomListResultSet;
import com.teamproject.devTalks.entity.user.UserEntity;
import com.teamproject.devTalks.repository.chat.ChatMessageRepository;
import com.teamproject.devTalks.repository.chat.ChatRoomRepository;
import com.teamproject.devTalks.repository.user.UserRepository;
import com.teamproject.devTalks.service.chat.ChatService;


@Service
public class ChatServiceImplement implements ChatService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final UserRepository userRepository;

    public ChatServiceImplement(ChatRoomRepository chatRoomRepository, 
    ChatMessageRepository chatMessageRepository, UserRepository userRepository) {
        this.chatRoomRepository = chatRoomRepository;
        this.chatMessageRepository = chatMessageRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> createChatRoom(PostChatRoomDto dto) {
        Integer fromNumber = dto.getFromNumber();
        Integer toNumber = dto.getToNumber();

        try {
        UserEntity userEntity1 = userRepository.findByUserNumber(fromNumber);
        if (userEntity1 == null) return CustomResponse.authenticationFailed();

        UserEntity userEntity2 = userRepository.findByUserNumber(toNumber);
        if (userEntity2 == null) return CustomResponse.noExistUser();
      
        ChatRoomEntity chatRoomEntity =  chatRoomRepository.findExistChatRoomCountByUserNumber(fromNumber, toNumber);
        if (chatRoomEntity != null) return CustomResponse.existChatRoom();

        String chatRoomNumber = UUID.randomUUID().toString();   
        ChatRoomEntity toChatRoomEntity = new ChatRoomEntity(chatRoomNumber, toNumber);
        chatRoomRepository.save(toChatRoomEntity);  
        System.out.println(toChatRoomEntity.toString());
        ChatRoomEntity fromChatRoomEntity = new ChatRoomEntity(chatRoomNumber, fromNumber);
        chatRoomRepository.save(fromChatRoomEntity);  
        System.out.println(fromChatRoomEntity.toString());  
  
        
        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();

    }

    @Override
    public ResponseEntity<ResponseDto> postChatMessage(PostChatMessageDto dto) {

        int fromNumber = dto.getFromNumber();
        String chatRoomNumber = dto.getChatRoomNumber();

        try {
            boolean existedUser = userRepository.existsByUserNumber(fromNumber);
            if (!existedUser) return CustomResponse.noExistUser();

            boolean existedChatRoom = chatRoomRepository.existsByChatRoomNumber(chatRoomNumber);
            if (!existedChatRoom) return CustomResponse.notExistChatRoomNumber();

            ChatMessageEntity chatMessageEntity = new ChatMessageEntity(dto);
            chatMessageRepository.save(chatMessageEntity);

            } catch (Exception exception) {
                exception.printStackTrace();
                return CustomResponse.databaseError();
            }

            return CustomResponse.success();
    }

    @Override
    public ResponseEntity<? super GetChatRoomListResponseDto> getChatRoomList(Integer userNumber) {
        
        GetChatRoomListResponseDto body = null;
        
        try {        
        List<ChatRoomListResultSet> resultSet = 
        chatRoomRepository.findAllByOrderBySentDatetimeDesc(userNumber);
        System.out.println(userNumber);
        body = new GetChatRoomListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(Integer userNumber, String chatRoomNumber) {     

        GetChatMessageListResponseDto body = null;

        try {
            boolean existedChatRoom = chatRoomRepository.existsByChatRoomNumber(chatRoomNumber);
            if(!existedChatRoom) return CustomResponse.notExistChatRoomNumber();

            chatMessageRepository.setChatStatusTrue(userNumber, chatRoomNumber);
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
    public ResponseEntity<ResponseDto> deleteChatRoom(String chatRoomNumber) {
        try {
            if (chatRoomNumber == null) return CustomResponse.validationFailed();

            ChatRoomEntity chatRoomEntity = 
            chatRoomRepository.findByChatRoomNumber(chatRoomNumber);
            if (chatRoomEntity == null) return CustomResponse.notExistChatRoomNumber();
            
            chatMessageRepository.deleteAllByChatRoomNumber(chatRoomNumber);
            chatRoomRepository.deleteByChatRoomNumber(chatRoomNumber);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteChatMessage(Integer chatMessageNumber) {

        try {
            if (chatMessageNumber == null) 
            return CustomResponse.validationFailed();

            List<ChatMessageEntity> chatMessageEntities = 
            chatMessageRepository.findByChatMessageNumber(chatMessageNumber);
            if (chatMessageEntities.isEmpty()) return CustomResponse.notExistChatMessageNumber();
            
            ChatMessageEntity chatMessageEntity = chatMessageEntities.get(0);
            chatMessageRepository.delete(chatMessageEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return CustomResponse.success();
    }
    }

