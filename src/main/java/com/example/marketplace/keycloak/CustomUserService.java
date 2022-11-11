package com.example.marketplace.keycloak;

import com.example.marketplace.dao.UserRepository;
import com.example.marketplace.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        User user = null;
        if (userRepository.findByUsername(username).isPresent()){
            user = userRepository.findByUsername(username).get();
        }
        return user;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int id){
        User user = null;
        if (userRepository.findById(id).isPresent()) {
            user = userRepository.findById(id).get();
        }
        return user;
    }

    public boolean validateCredentials(String username, String password) {
        return findByUsername(username).getPassword().equals(password);
    }

    public boolean updateCredentials(String username, String password) {
        findByUsername(username).setPassword(password);
        return true;
    }

}
