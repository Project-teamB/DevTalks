package com.teamproject.devTalks.service.implement.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teamproject.devTalks.common.util.CustomResponse;
import com.teamproject.devTalks.dto.request.chat.PostChatMessageDto;
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
    public ResponseEntity<ResponseDto> createChatRoom(Integer userNumber) {

        if (userNumber == null) return CustomResponse.validationFailed();

        try {
        UserEntity userEntity = userRepository.findByUserNumber(userNumber);
        if (userEntity == null) return CustomResponse.noExistUser();

        ChatRoomEntity existingChatRoom = chatRoomRepository.findByUserNumber(userNumber);
        if (existingChatRoom != null) return CustomResponse.existChatRoom();

        ChatRoomEntity chatRoomEntity = new ChatRoomEntity();
        String chatRoomNumber = UUID.randomUUID().toString();

        chatRoomEntity.setChatRoomNumber(chatRoomNumber);
        chatRoomEntity.setUserNumber(userNumber);        
        chatRoomRepository.save(chatRoomEntity);    
        
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
        chatRoomRepository.findAllByOrderBySentDatetimeDesc();
        body = new GetChatRoomListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(body);

    }

    @Override
    public ResponseEntity<? super GetChatMessageListResponseDto> getChatMessageList(GetChatMessageListResponseDto dto) {     

        int fromNumber = dto.getFromNumber();
        String chatRoomNumber = dto.getChatRoomNumber();

        try {
            boolean existedUser = userRepository.existsByUserNumber(fromNumber);
            if (!existedUser) return CustomResponse.noExistUser();

            boolean existedChatRoom = chatRoomRepository.existsByChatRoomNumber(chatRoomNumber);
            if(!existedChatRoom) return CustomResponse.notExistChatRoomNumber();

            chatMessageRepository.setChatStatusTrue(chatRoomNumber);
            List<ChatMessageListResultSet> resultSet = 
            chatMessageRepository.getListOrderBySentDatetime(chatRoomNumber);

            GetChatMessageListResponseDto body = new GetChatMessageListResponseDto(resultSet);
            return ResponseEntity.status(HttpStatus.OK).body(body);

        } catch (Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
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
    public ResponseEntity<ResponseDto> deleteChatMessage(String chatRoomNumber, Integer chatMessageNumber) {

        try {
            if (chatRoomNumber == null||chatMessageNumber == null) 
            return CustomResponse.validationFailed();

            ChatRoomEntity chatRoomEntity = 
            chatRoomRepository.findByChatRoomNumber(chatRoomNumber);
            if (chatRoomEntity == null) return CustomResponse.notExistChatRoomNumber();

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

