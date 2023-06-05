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

        // 세션의 헤더에서 토큰을 가져온다
        String token = session.getHandshakeHeaders().getFirst("Authorization");

        // 토큰을 검증한다.
        String email = jwtProvider.validateJwt(token);

        // 검증 실패하면 close 시킨다.        
        boolean existedUser = userService.isExistedUser(email);
        if (!existedUser) {
            session.close();
            return;
        }

        // 검증이 성공했다면 userService에 만들어 놓은 로그인 상태 변화 메서드를 검증 결과인 userEmail을 포함하여 호출한다.
        

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

        // 세션의 헤더에서 토큰을 가져온다.

        // 토큰을 검증한다.

        // 검증 실패하면 close 시킨다.

        // 검증이 성공했다면 userService에 만들어 놓은 로그인 상태 변화 메서드를 검증 결과인 userEmail을 포함하여 호출한다.
    }
}
