/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "FNAME")
    private String firstName;
    @Column(name = "LNAME")
    private String lastName;
    @Column(name = "BIRTHDATE")
    private String birthDate;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;

    @Override
    public String toString() {
        return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
                + ", email=" + email + ", phone=" + phone + "]";
    }
}
