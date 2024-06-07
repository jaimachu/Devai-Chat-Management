package com.devai.Devai_Chat_Management.service;

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
    private final CopyOnWriteArrayList<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>(); // Lista concurrente

    // Qué voy a hacer una vez se realice una conexion con el socket
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    // Una vez se cierre una sesion que voy a hacer

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
    }

    // Se va a enviar a los receptores el correspondiente mensaje que envia un usuario
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : sessions){
            webSocketSession.sendMessage(message);
        }
    }
}
