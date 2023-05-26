package com.teamproject.devTalks.repository.chat;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Message;
import com.teamproject.devTalks.entity.chat.ChatRoomEntity;
import com.teamproject.devTalks.entity.resultSet.chat.ChatRoomListResultSet;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity, Integer> {

    boolean existsByChatRoomNumber(String chatRoomNumber);

    @Query (value = "SELECT R.chat_room_number AS chatRoomNumber" +
    "FROM chat_room R" +
    "LEFT JOIN chat_message M ON R.chat_room_number = M.chat_room_number" +
    "LEFT JOIN user U ON M.from_number = U.user_number" +
    "WHERE R.chat_room_number IN" +
    "(SELECT chat_room_number FROM chat_room" +
    "WHERE user_number = ?)" +
    "AND U.user_number <> ?" +
    "ORDER BY M.sent_datetime DESC", nativeQuery = true)
    List<ChatRoomListResultSet> findAllByOrderBySentDatetimeDesc();
    
    ChatRoomEntity findByChatRoomNumber(String chatRoomNumber);

    @Query(value = "SELECT * FROM chat_room R " +
    "WHERE EXISTS (" +
    "SELECT 1 FROM chat_message M " +
    "LEFT JOIN user U ON M.from_number = U.user_number " +
    "WHERE M.chat_room_number = R.chat_room_number " +
    "AND U.user_number = :userNumber" +
    ")", nativeQuery = true)
    ChatRoomEntity findByUserNumber(@Param("userNumber") Integer userNumber);

    @Transactional
    void deleteByChatRoomNumber(String chatRoomNumber);

    }
