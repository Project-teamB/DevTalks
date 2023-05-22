package com.teamproject.devTalks.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class WebSocketProvider extends TextWebSocketHandler {
    
    private static List<WebSocketSession> list = new ArrayList<>();
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    // WebSocket 연결이 열릴 때 실행되는 코드(연결된 클라이언트를 저장하거나 초기화 작업)        
        list.add(session);
        log.info(session + " 채팅 연결");

}

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 메시지 송수신
        String payload = message.getPayload();
        log.info("payload : " + payload);

        for(WebSocketSession webSocketSession: list) {
            webSocketSession.sendMessage(message);
        }
}

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    // WebSocket 연결이 닫힐 때 실행되는 코드(연결이 닫힌 클라이언트를 처리하거나 마무리 작업) 
        log.info(session + "  채팅 종료");
        list.remove(session);
}


}
