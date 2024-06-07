package com.devai.Devai_Chat_Management.services.ChatService;

import java.util.List;

import com.devai.Devai_Chat_Management.model.Chat;
import com.devai.Devai_Chat_Management.model.User;

public interface ChatService {
    List<Chat> getUsersChat(Long idUser);
    User getUserByChat(Long idChat, Long idUser);
    Chat createChat(Long idUser1, Long idUser2);
    void deleteChat(Long idChat, Long idUser1, Long idUser2);
}
