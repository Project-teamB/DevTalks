package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.chat.ChatMessageEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatMessageListResultSet;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {

    @Query(value = "SELECT M.message_number, M.message, M.sent_datetime, U.user_number" +
    "FROM chat_message M, chat_room R, user U" +
    "LEFT JOIN user U ON M.user_number = U.user_number" +
    "LEFT JOIN chat_room R ON M.chat_room_number = R.chat_room_number" +
    "WHERE M.chat_room_number = :chatRoomNumber" +
    "ORDER BY M.sent_datetime", nativeQuery = true)
    public List<ChatMessageListResultSet> getListOrderBySentDatetime(String chatRoomNumber);


    }


