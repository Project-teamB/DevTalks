package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.chat.ChatRoomEntity;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Integer> {

    @Query (value = "SELECT R.chat_room_number AS chatRoomNumber" +
    "FROM chat_room R" +
    "LEFT JOIN chat_message M ON R.chat_room_number = M.chat_room_number" +
    "LEFT JOIN user U ON M.from_number = U.user_number" +
    "WHERE R.chat_room_number IN" +
    "(SELECT chat_room_number FROM chat_room" +
    "WHERE user_number = ?)" +
    "AND U.user_number <> ?" +
    "ORDER BY M.sent_datetime DESC", nativeQuery = true)
    List<ChatRoomEntity> findAllByOrderBySentDatetimeDesc();

    ChatRoomEntity findByChatRoomNumber(String chatRoomNumber);
}
