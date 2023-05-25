package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.chat.ChatMessageEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatMessageListResultSet;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {


    List<ChatMessageListResultSet> getListOrderBySentDatetime(String chatRoomNumber);
    }


