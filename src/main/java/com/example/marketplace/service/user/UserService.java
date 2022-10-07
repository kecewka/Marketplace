package com.example.marketplace.service.user;

import com.example.marketplace.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);

}
