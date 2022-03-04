package com.example.demo.user.service;

import com.example.demo.user.model.User;
import com.example.demo.user.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        userRepository.save(user);
        return user;
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("user with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }

    @Bean
    public List<User> retrieveGetMyUser2() {
        List<User> myList = new ArrayList<User>();
        myList.add(        new User(
                "Sibel",
                "sibel@gmail.com",
                LocalDate.of(1996, Month.JULY, 12),
                "url",
                "0737203358"
        ));
        myList.add(        new User(
                "Serhan",
                "serhanct@gmail.com",
                LocalDate.of(1993, Month.JULY, 12),
                "url",
                "0737203358"
        ));

        return myList;
    }

    @Bean(name = "retrieveGetMyUser")
    public User retrieveGetMyUser() {
        return new User(
                "Serhan",
                "serhanct@gmail.com",
                LocalDate.of(1993, Month.JULY, 12),
                "url",
                "0737203358"
        );
    }

    @Transactional
    public User updateUser(User user) {
        User selectedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalStateException("User with id " + user.getId() + " does not exists"));
        selectedUser.setName(user.getName());
        selectedUser.setEmail(user.getEmail());
        selectedUser.setImageUrl(user.getImageUrl());
        selectedUser.setPhoneNumber(user.getPhoneNumber());
        return selectedUser;
    }

//    @Transactional
//    public void updateUser(Long userId, String name, String email, String imageUrl, String phoneNumber) {
//
//        User selectedUser = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalStateException("User with id " + userId + " does not exists"));
//
//        if(name != null && !Objects.equals(name,"null") && name.length() > 0 && !Objects.equals(name, selectedUser.getName())) {
//            selectedUser.setName(name);
//        } else {
//            throw new IllegalStateException("name is the same or null");
//        }
//
//        if(email != null && email.length() > 0 && !Objects.equals(email, selectedUser.getEmail())) {
//            Optional <User> userOptional = userRepository.findUserByEmail(email);
//            if(userOptional.isPresent()) {
//                throw new IllegalStateException("email taken! you should reconsider to change to another email");
//            }
//            selectedUser.setEmail(email);
//        }
//
//        selectedUser.setImageUrl(imageUrl);
//        selectedUser.setPhoneNumber(phoneNumber);
//    }

}
