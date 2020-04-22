package ru.kpfu.itis.demo.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VoiceSocketHandler extends AbstractWebSocketHandler {

    private List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        sessions.stream().filter(WebSocketSession::isOpen).forEach(webSocketSession -> {
            try {
                webSocketSession.sendMessage(message);
            } catch (IOException ignore) { }
        });
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}
