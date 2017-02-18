/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security;

import com.user.User;
import com.user.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tazzmanian
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.out.println(user.getFirstName() + " " + user.getUsername());
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with username: " + username);
        }
        return user;
    }

    public List<User> getAllFlaggedUsers() {
        return userRepository.findByEnabledTrue();
    }

    public List<User> getAllUnflaggedUsers() {
        return userRepository.findByEnabledFalse();
    }

    public User changeFlag(String name) {
        User user = userRepository.findByUsername(name);
        user.setEnabled(!user.isEnabled());
        userRepository.save(user);
        return user;
    }

}
