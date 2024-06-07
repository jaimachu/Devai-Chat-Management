package com.devai.Devai_Chat_Management.model.UserChat;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "USER_CHAT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserChat {
    @EmbeddedId
    private CKUserChat id;
}
