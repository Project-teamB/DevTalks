package com.teamproject.devTalks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.teamproject.devTalks.provider.ChatWebSocketHandler;
import com.teamproject.devTalks.provider.SignInWebSocketHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler chatWebSocketHandler;
    private final SignInWebSocketHandler signInWebSocketHandler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        
        registry
            .addHandler(chatWebSocketHandler, "/web-socket")
            .addHandler(signInWebSocketHandler, "/web-socket/sign-in")
            .setAllowedOrigins("*");

    }


}