/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.service;

import com.security.dao.UserRepository;
import com.security.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    public void save(User person) {
        userRepository.save(person);
    }

    public User findPerson(int id) {
        return userRepository.findOne(id);
    }

    public void delete(int id) {
        if (userRepository.exists(id)) {
            userRepository.delete(id);
        }
    }
}
