package com.teamproject.devTalks.entity.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.teamproject.devTalks.dto.response.chat.GetChatMessageListResponseDto;
import com.teamproject.devTalks.entity.user.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chat_message")
@Table(name = "chat_message")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int chatMessageNumber;
    private int fromNumber;
    private String message;
    private String sentDatetime;
    private String chatRoomNumber;
    private boolean chatStatus;


    public ChatMessageEntity(UserEntity userEntity, ChatRoomEntity chatRoomEntity, GetChatMessageListResponseDto dto){

        this.chatMessageNumber = getChatMessageNumber();
        this.fromNumber = userEntity.getUserNumber();
        this.message = getMessage();
        this.sentDatetime = getCurrentDateTime();
        this.chatRoomNumber = chatRoomEntity.getChatRoomNumber();
        this.chatStatus = false;
    }

    private String getCurrentDateTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(now);
    }
}
