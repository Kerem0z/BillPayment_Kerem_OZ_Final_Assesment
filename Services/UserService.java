package com.example.demo.Services;

import com.example.demo.Entitys.User;
import com.example.demo.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
    public ResponseEntity<User> updateUser(User user){
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public Optional<User> findUser(Long userId){
        return userRepository.findById(userId);
    }
}



