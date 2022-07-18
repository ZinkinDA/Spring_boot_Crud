package com.example.crud_spring.dao;

import com.example.crud_spring.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserAll();

    User getUserIndex(int index);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
