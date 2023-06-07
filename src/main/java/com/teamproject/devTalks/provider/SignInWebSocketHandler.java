package com.teamproject.devTalks.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.teamproject.devTalks.service.user.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
// email, websocketsession class를 작성
@Getter
@AllArgsConstructor
class SignInObject {

    private String userEmail;
    private WebSocketSession session;

}

@Component
@RequiredArgsConstructor
public class SignInWebSocketHandler extends TextWebSocketHandler {

    // arrayList 작성    
    // 생성    
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private static List<SignInObject> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        String token = session.getHandshakeHeaders().getFirst("Authorization");
        String email = jwtProvider.validateJwt(token);
       
        boolean existedUser = userService.isExistedUser(email);
        if (!existedUser) {
            session.close();
            return;
        }

        userService.changeUserStatus(email, true);

        SignInObject signInObject = new SignInObject(email, session);
        sessions.add(signInObject);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        
        for (SignInObject signInObject : sessions) {
            WebSocketSession objectSession = signInObject.getSession();

            boolean isEqualSession = objectSession.getId().equals(session.getId());
            if (!isEqualSession) continue;

            String email = signInObject.getUserEmail();
            userService.changeUserStatus(email, false);
            sessions.remove(signInObject); 
            break;
        }
    }

}
