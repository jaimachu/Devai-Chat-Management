package com.devai.Devai_Chat_Management.repository.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devai.Devai_Chat_Management.model.Chat;
import com.devai.Devai_Chat_Management.model.User;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>{
    // métodos aquí
}
