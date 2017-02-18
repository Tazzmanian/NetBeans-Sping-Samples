/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Tazzmanian
 */
@RestController
public class UserController {

    @Autowired
    private UserService services;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public User save(@RequestBody User user) {
        return services.save(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getAllUsers() {
        return services.getAllUsers();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUser(@PathVariable Long id) throws Exception {

        return services.getUserById(id);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }
}
