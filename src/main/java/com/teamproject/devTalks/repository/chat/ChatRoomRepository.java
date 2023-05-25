package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.chat.ChatRoomEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatRoomListResultSet;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Integer> {

    // List<ChatRoomEntity> findAllByOrderBySentDatetimeDesc();


    ChatRoomEntity findByChatRoomNumber(String chatRoomNumber);
}
