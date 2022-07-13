package com.example.crud_spring.service;

import com.example.crud_spring.dao.UserRepository;
import com.example.crud_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(User user){
        userRepository.saveAndFlush(user);
    }

    public void deleteUser(Integer id){
        userRepository.delete(getUserById(id));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.getReferenceById(id);
    }

    public void updateUser(int id,User user){
        user.setId(id);
        userRepository.deleteById(id);
        userRepository.save(user);
    }
    

}
