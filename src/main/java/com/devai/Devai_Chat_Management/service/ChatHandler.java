package com.devai.Devai_Chat_Management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@CrossOrigin
@Service
public class ChatHandler extends TextWebSocketHandler{
    private final ConcurrentHashMap<String, List<WebSocketSession>> sessions = new ConcurrentHashMap<>();

    // Establecimiento de la conexión
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String uri = session.getUri().toString();
        String sessionId = uri.split("sessionId=")[1].split("\\?")[0];
        if (!sessions.containsKey(sessionId)){
            List<WebSocketSession> listSessions = new ArrayList<>();
            listSessions.add(session);
            sessions.put(sessionId, listSessions);
        }
        else{
            sessions.get(sessionId).add(session);
        }
    }

    // Cierre de la conexión

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String sessionId = session.getId();
        sessions.remove(sessionId);
    }

    // Se va a enviar a los receptores el correspondiente mensaje que envia un usuario
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String uri = session.getUri().toString();
        String sessionId = uri.split("sessionId=")[1].split("\\?")[0];
        String destinationId = uri.split("destinationId=")[1];
        String stringMessage = message.getPayload();
        List<WebSocketSession> sessionList = sessions.get(sessionId);
        if (sessionList != null) {
            for (WebSocketSession webSocketSession : sessionList) {
                webSocketSession.sendMessage(new TextMessage(destinationId+":"+stringMessage));
            }
        }
    }
}
