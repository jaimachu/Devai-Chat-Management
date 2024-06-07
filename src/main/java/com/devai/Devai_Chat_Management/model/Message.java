package com.devai.Devai_Chat_Management.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Table(name="MESSAGE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="idUser")
    private Long userId;
    @Column(name="idChat")
    private Long chatId;
    @Column(name="type")
    private String type;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="idType")
    private Long idType;
    @Column(name="url")
    private String url;
}
