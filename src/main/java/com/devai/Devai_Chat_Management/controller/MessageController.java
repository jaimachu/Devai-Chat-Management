package com.devai.Devai_Chat_Management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devai.Devai_Chat_Management.model.Message;
import com.devai.Devai_Chat_Management.services.MessageService.MessageService;

@RestController
@RequestMapping("/message/")
public class MessageController {

    private final MessageService messageService;
    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }
    
    @GetMapping("/user/{idUser}")
    public ResponseEntity<?> getMessagesUser(@PathVariable Long idUser){
        try{
            List<Message> messages = messageService.getMessagesUser(idUser);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/chat/{idChat}")
    public ResponseEntity<?> getMessagesChat(@PathVariable Long idChat){
        try{
            List<Message> messages = messageService.getMessagesChat(idChat);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createMessage(@RequestBody Message newMessage){
        try{
            Message message = messageService.createMessage(newMessage);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable Long id){
        try{
            Message message = messageService.deleteMessage(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("BAD_REQUEST", HttpStatus.BAD_REQUEST);

        }
    }
}
