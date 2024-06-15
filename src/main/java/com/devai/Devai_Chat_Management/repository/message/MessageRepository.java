package com.devai.Devai_Chat_Management.repository.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devai.Devai_Chat_Management.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{
    // Obtiene todos los mensajes que tiene un usuario
    List<Message> findByUserId(Long idUser);
    // Obtiene todos los mensajes de un chat
    List<Message> findByChatId(Long idChat);
    // Elimina todos los mensajes que pertenecian a un chat
    void deleteByChatId(Long idChat);
}
