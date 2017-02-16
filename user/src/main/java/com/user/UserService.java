/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import com.exceptions.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tazzmanian
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User save(User user) {
        return repo.save(user);
    }

    public User getUserById(Long id) throws Exception {
        User user = repo.findById(id);

        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    public User remove(Long id) {
        if (repo.exists(id)) {
            User temp = repo.findOne(id);
            repo.delete(id);
            return temp;
        }

        return null;
    }

    public User update(Long id, User user) {
        User dbUser = repo.findOne(id);
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setBirthDate(user.getBirthDate());
        dbUser.setPhone(user.getPhone());
        dbUser.setEmail(user.getEmail());
        return repo.save(dbUser);
    }
}
