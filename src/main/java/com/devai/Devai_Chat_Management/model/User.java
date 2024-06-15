package com.devai.Devai_Chat_Management.model;

import java.lang.reflect.Field;

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
@Table(name = "USER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "idTypeUser")
    private Long idTypeUser = 2L;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "profilePhoto")
    private String profilePhoto = "img/defaultPhoto.png";
    @Column(name = "idState")
    private Long idState = 2L;

    public void updateUser(User userNew){
        Class<?> className = this.getClass();
        Field[] attributes = className.getDeclaredFields();
        for (Field attribute: attributes){
            attribute.setAccessible(true);
            try {
                Object newValue = attribute.get(userNew);
                if (newValue != null && attribute.getName() != "id") {
                    attribute.set(this, newValue);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
