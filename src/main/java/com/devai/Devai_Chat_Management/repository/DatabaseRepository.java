package com.devai.Devai_Chat_Management.repository;

import org.springframework.stereotype.Component;

import com.devai.Devai_Chat_Management.repository.chat.ChatRepository;
import com.devai.Devai_Chat_Management.repository.message.MessageRepository;
import com.devai.Devai_Chat_Management.repository.user.UserRepository;
import com.devai.Devai_Chat_Management.repository.userChat.UserChatRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Component
@Getter
@AllArgsConstructor
public class DatabaseRepository {
    private final UserRepository userRepository;
    private final UserChatRepository userChatRepository;
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;
}
