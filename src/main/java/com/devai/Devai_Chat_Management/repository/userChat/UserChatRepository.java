package com.devai.Devai_Chat_Management.repository.userChat;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devai.Devai_Chat_Management.model.User;
import com.devai.Devai_Chat_Management.model.UserChat.CKUserChat;
import com.devai.Devai_Chat_Management.model.UserChat.UserChat;

public interface UserChatRepository extends JpaRepository<UserChat, CKUserChat>{
    
}
