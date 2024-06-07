package com.devai.Devai_Chat_Management.services.ChatService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devai.Devai_Chat_Management.model.Chat;
import com.devai.Devai_Chat_Management.model.User;
import com.devai.Devai_Chat_Management.model.UserChat.CKUserChat;
import com.devai.Devai_Chat_Management.model.UserChat.UserChat;
import com.devai.Devai_Chat_Management.repository.DatabaseRepository;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    DatabaseRepository databaseRepository;

    @Override
    public List<Chat> getUsersChat(Long idUser) {
        List<UserChat> allUserChats = databaseRepository.getUserChatRepository().findAll();
        HashSet<Chat> chats = new HashSet<>();
        for (UserChat userChat : allUserChats){
            if (userChat.getId().getUserId() == idUser)
                chats.add(new Chat(userChat.getId().getChatId()));
        }
        return new ArrayList<>(chats);
        // TODO: Comprobar que los dos users pertenecen al chat
        /* 
        CKUserChat idUserChat1 = new CKUserChat(idUser1, idChat);
        CKUserChat idUserChat2 = new CKUserChat(idUser2, idChat);
        Optional<UserChat> userChat1 = databaseRepository.getUserChatRepository().findById(idUserChat1);
        Optional<UserChat> userChat2 = databaseRepository.getUserChatRepository().findById(idUserChat2);
        if (userChat1.isPresent() && userChat2.isPresent()){
            List<User> users = new ArrayList<>();
            Optional<User> user1 = databaseRepository.getUserRepository().findById(idUser1);
            Optional<User> user2 = databaseRepository.getUserRepository().findById(idUser2);
            users.add(user1.get());
            users.add(user2.get());
            return users;
        }
        throw new UnsupportedOperationException("Los usuarios no pertenecen en ningún chat");
        */
    }

    @Override
    public User getUserByChat(Long idChat, Long idUser){
        List<UserChat> allUserChats = databaseRepository.getUserChatRepository().findAll();
        for (UserChat userChat : allUserChats){
            if (userChat.getId().getChatId() == idChat && userChat.getId().getUserId() != idUser){
                User user = databaseRepository.getUserRepository().findById(userChat.getId().getUserId()).get();
                return user;
            }
        }
        return new User();
    }

    @Override
    public Chat createChat(Long idUser1, Long idUser2) {
        // TODO: Comprobar que no existe un chat entre los dos usuarios
        Chat chat = new Chat();
        databaseRepository.getChatRepository().save(chat);
        Long chatId = chat.getId();
        CKUserChat ckUser1 = new CKUserChat(idUser1, chatId);
        CKUserChat ckUser2 = new CKUserChat(idUser2, chatId);
        databaseRepository.getUserChatRepository().save(new UserChat(ckUser1));
        databaseRepository.getUserChatRepository().save(new UserChat(ckUser2));
        return chat;
    }
    
    @Override
    public void deleteChat(Long idChat, Long idUser1, Long idUser2){
        CKUserChat ckUser1 = new CKUserChat(idUser1, idChat);
        CKUserChat ckUser2 = new CKUserChat(idUser2, idChat);
        databaseRepository.getUserChatRepository().deleteById(ckUser1);
        databaseRepository.getUserChatRepository().deleteById(ckUser2);
        databaseRepository.getChatRepository().deleteById(idChat);
    }
}
