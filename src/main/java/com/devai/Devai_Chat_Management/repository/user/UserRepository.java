package com.devai.Devai_Chat_Management.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devai.Devai_Chat_Management.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByTelephone(String telephone);
    User findByEmail(String email);

}
