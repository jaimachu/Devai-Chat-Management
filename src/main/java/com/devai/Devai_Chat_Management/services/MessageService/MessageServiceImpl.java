package com.devai.Devai_Chat_Management.services.MessageService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devai.Devai_Chat_Management.model.Message;
import com.devai.Devai_Chat_Management.repository.DatabaseRepository;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    DatabaseRepository databaseRepository;

    @Override
    public Message createMessage(Message newMessage) {
        Message messageCorrect = databaseRepository.getMessageRepository().save(newMessage);
        return messageCorrect;
    }

    @Override
    public List<Message> getMessagesUser(Long idUser) {
        List<Message> messages = databaseRepository.getMessageRepository().findByUserId(idUser);
        return messages;
    }

    @Override
    public List<Message> getMessagesChat(Long idChat) {
        List<Message> messages = databaseRepository.getMessageRepository().findByChatId(idChat);
        return messages;
    }

    @Override
    public Message deleteMessage(Long id) {
        Optional<Message> messageDeleted = databaseRepository.getMessageRepository().findById(id);
        databaseRepository.getMessageRepository().deleteById(id);
        return messageDeleted.get();
    }
    
}
