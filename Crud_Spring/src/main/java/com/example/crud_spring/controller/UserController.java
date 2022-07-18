package com.example.crud_spring.controller;

import com.example.crud_spring.model.User;
import com.example.crud_spring.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String getAllUsers(Model model){
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "users";
    }
    @GetMapping("/{index}")
    public String getUserIndex(@PathVariable("index") int index, Model model) {
        model.addAttribute("person", userServiceImpl.getUserById(index));
        return "person";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "/new";
    }
    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user){
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{index}/update")
    public String updateUser(Model model,@PathVariable("index") int id){
        model.addAttribute("user", userServiceImpl.getUserById(id));
        return "/update";
    }

    @PostMapping ("/{index}")
    public String update(@ModelAttribute("user") User user,@PathVariable("index") int id){
        userServiceImpl.updateUser(id,user);
        return "redirect:/users";
    }
    @RequestMapping(value = {"/{index}"},method = RequestMethod.DELETE)
    public String delete(@PathVariable("index") int id){
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }

}
