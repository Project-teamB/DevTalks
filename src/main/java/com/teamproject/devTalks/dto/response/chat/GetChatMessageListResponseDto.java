package com.teamproject.devTalks.dto.response.chat;

import java.util.ArrayList;
import java.util.List;

import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.entity.resultSet.chat.ChatMessageListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class GetChatMessageListResponseDto extends ResponseDto {

    private List<ChatMessage> ChatMessageList;

    public GetChatMessageListResponseDto(List<ChatMessageListResultSet> resultSetList) {
        ChatMessageList = new ArrayList<>();
        for (ChatMessageListResultSet resultSet : resultSetList) {
            ChatMessage chatMessage = new ChatMessage(resultSet);
            ChatMessageList.add(chatMessage);
        }

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    class ChatMessage {
        private String chatRoomNumber;
        private int chatMessageNumber;
        private String userProfileImageUrl;
        private String userNickname;
        private String sentDatetime;
        private String chatMessage;
        private String chatMessageImageUrl;

        public ChatMessage(ChatMessageListResultSet resultSet) {
            this.chatRoomNumber = resultSet.getChatRoomNumber();
            this.chatMessageNumber = resultSet.getChatMessageNumber();
            // this.userNickname = resultSet.getUserNickname();
            this.sentDatetime = resultSet.getSentDatetime();
            this.chatMessage = resultSet.getMessage();
        }
    }

}
