package com.devai.Devai_Chat_Management.services.MessageService;


import java.util.List;

import com.devai.Devai_Chat_Management.model.Message;

public interface MessageService {
    Message createMessage(Message newMessage);
    List<Message> getMessagesUser(Long idUser);
    List<Message> getMessagesChat(Long idChat);
    Message deleteMessage(Long id);
}
