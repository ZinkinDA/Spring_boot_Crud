package com.example.crud_spring.controller;

import com.example.crud_spring.model.User;
import com.example.crud_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping("/{index}")
    public String getUserIndex(@PathVariable("index") int index, Model model) {
        model.addAttribute("person",userService.getUserById(index));
        return "person";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user",new User());
        return "/new";
    }
    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{index}/update")
    public String updateUser(Model model,@PathVariable("index") int id){
        model.addAttribute("user",userService.getUserById(id));
        return "/update";
    }

    @PostMapping ("/{index}")
    public String update(@ModelAttribute("user") User user,@PathVariable("index") int id){
        userService.updateUser(id,user);
        return "redirect:/users";
    }
    @RequestMapping(value = {"/{index}"},method = RequestMethod.DELETE)
    public String delete(@PathVariable("index") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
