/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Tazzmanian
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Works
    public User findById(Long id);

    // default
    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContaining(
            String firstName, String lastName, String date, String email, String phone);

    // Sort by last name
    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAsc(
            String firstName, String lastName, String date, String email, String phone);

    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDesc(
            String firstName, String lastName, String date, String email, String phone);

    // Sort by date
    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateAsc(
            String firstName, String lastName, String date, String email, String phone);

    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateDesc(
            String firstName, String lastName, String date, String email, String phone);

    // combined sort
    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateAsc(
            String firstName, String lastName, String date, String email, String phone);

    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateDesc(
            String firstName, String lastName, String date, String email, String phone);

    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateAsc(
            String firstName, String lastName, String date, String email, String phone);

    public List<User> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateDesc(
            String firstName, String lastName, String date, String email, String phone);

    public User findByUsername(String username);
}
