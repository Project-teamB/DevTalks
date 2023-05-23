package com.teamproject.devTalks.controller.chat;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamproject.devTalks.dto.request.chat.CreateChatMessageRequestDto;
import com.teamproject.devTalks.dto.response.ResponseDto;
import com.teamproject.devTalks.security.UserPrinciple;
import com.teamproject.devTalks.service.chat.ChatService;
import com.teamproject.devTalks.dto.response.chat.GetChatRoomListResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/chat")
public class ChatController {

        }

