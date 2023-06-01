package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamproject.devTalks.entity.chat.UserBlockEntity;
import com.teamproject.devTalks.entity.primaryKey.chat.UserBlockPK;

@Repository
public interface UserBlockRepository extends JpaRepository<UserBlockEntity, UserBlockPK>{
    
    public boolean existsBySenderNumberAndReceiverNumber(Integer senderNumber, Integer receiverNumber);

    public List<UserBlockEntity> findBySenderNumber(Integer senderNumber);
    public List<UserBlockEntity> findByReceiverNumber(Integer receiverNumber);

    @Query(value = "SELECT U.user_nickname " +
    "FROM user_block B " +
    "LEFT JOIN user U ON U.user_number = B.receiver_number " +
    "WHERE B.sender_number = :senderNumber", nativeQuery = true)
    public List<String> findAllBlockUserNicknameByUserNumber(@Param("senderNumber") Integer senderNumber);
}
