package com.teamproject.devTalks.repository.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamproject.devTalks.entity.chat.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Integer> {

}
