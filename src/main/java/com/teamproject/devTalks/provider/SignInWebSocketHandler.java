package com.teamproject.devTalks.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.teamproject.devTalks.service.user.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignInWebSocketHandler extends TextWebSocketHandler {
    
    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String token = session.getHandshakeHeaders().getFirst("Authorization");
        String email = jwtProvider.validateJwt(token);
       
        boolean existedUser = userService.isExistedUser(email);
        if (!existedUser) {
            session.close();
            return;
        }

        userService.changeUserStatus(email);
 

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        String token = session.getHandshakeHeaders().getFirst("Authorization");
        String email = jwtProvider.validateJwt(token);
    
        boolean existedUser = userService.isExistedUser(email);
        if (!existedUser) {
            session.close();
            return;
        }

        userService.changeUserStatus(email);

    }
}
