package com.teamproject.devTalks.entity.chat;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@Entity(name = "chat_message")
@Table(name = "chat_message")
public class ChatMessageEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int chatMessageNumber;
    private int fromNumber;
    private String message;
    private String sentDatetime;
    private int chatRoomNumber;
    private boolean chatStatus;

    }

