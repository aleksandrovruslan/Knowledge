package com.aleksandrov.Knowledge.controllers;

import com.aleksandrov.Knowledge.models.User;
import com.aleksandrov.Knowledge.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    public User get (@PathVariable long id) {
        return userService.getUser(id);
    }

    @PostMapping("add/")
    public User add (@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void delete (@PathVariable long id) {
        userService.deleteUser(id);
    }

    @PutMapping("edit/")
    public User edit(@RequestBody User user) {
        return userService.editUser(user);
    }

    @GetMapping("list")
    public List<User> list() {
        return userService.listUsers();
    }
}
