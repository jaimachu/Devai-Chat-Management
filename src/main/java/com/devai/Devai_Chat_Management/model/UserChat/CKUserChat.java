package com.devai.Devai_Chat_Management.model.UserChat;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Clase que representa la clave primaria
 * de UserChat, compuesta el idUser y idChat
 */
@Embeddable
public class CKUserChat {
    @Column(name="idUser")
    private Long userId;
    @Column(name="idChat")
    private Long chatId;

    public CKUserChat() {
        
    }

    public CKUserChat(Long id1, Long id2){
        userId = id1;
        chatId = id2;
    }

    public Long getUserId(){
        return userId;
    }

    public Long getChatId(){
        return chatId;
    }
}
