package com.teamproject.devTalks.entity.chat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chat_room")
@Table(name = "chat_room")
public class ChatRoomEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String chatRoomNumber;
    private int userNumber;
}
