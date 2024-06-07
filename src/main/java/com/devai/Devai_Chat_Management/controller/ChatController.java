package com.devai.Devai_Chat_Management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devai.Devai_Chat_Management.model.Chat;
import com.devai.Devai_Chat_Management.model.User;
import com.devai.Devai_Chat_Management.services.ChatService.ChatService;

@RestController
@RequestMapping("/chat/")
public class ChatController {
    
    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping("/{idUser}")
    public List<Chat> getChat(@PathVariable Long idUser){
        List<Chat> chats = chatService.getUsersChat(idUser);
        return chats;
    }

    @GetMapping("/{idChat}/{idUser}")
    public User getUserByChat(@PathVariable Long idChat, @PathVariable Long idUser){
        User user = chatService.getUserByChat(idChat, idUser);
        return user;
    }

    @PostMapping("/{idUser1}/{idUser2}")
    public Chat createChat(@PathVariable Long idUser1, @PathVariable Long idUser2){
        Chat chat = chatService.createChat(idUser1, idUser2);
        return chat;
    }

    @DeleteMapping("/{idChat}/{idUser1}/{idUser2}")
    public void DeleteChat(@PathVariable Long idChat, @PathVariable Long idUser1, @PathVariable Long idUser2){
        chatService.deleteChat(idChat, idUser1, idUser2);
    }
}
