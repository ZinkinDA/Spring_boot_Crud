package com.example.crud_spring.service;

import com.example.crud_spring.dao.UserDao;
import com.example.crud_spring.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    void deleteUser(Integer id);

    List<User> getAllUsers();

    User getUserById(Integer id);

    void updateUser(int id,User user);

}
