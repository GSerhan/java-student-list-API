package com.example.demo.user.controller;

import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    private final List<User> myUsers;

    @Autowired
    public UserController(UserService userService,
                          @Qualifier("retrieveGetMyUser2") List<User> myUsersFromService) {
        this.userService = userService;
        this.myUsers = myUsersFromService;
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping("/add")
    public User registerNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
//    public void updateUser(@PathVariable("userId") Long userId,
//                              @RequestParam(required = false) String name,
//                              @RequestParam(required = false) String email,
//                              @RequestParam(required = false) String imageUrl,
//                              @RequestParam(required = false) String phoneNumber
//                           ) {
//        userService.updateUser(userId, name, email, imageUrl, phoneNumber);
//    }
}
