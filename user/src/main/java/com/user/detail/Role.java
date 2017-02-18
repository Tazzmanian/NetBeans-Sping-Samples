/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.detail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.user.User;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Data;

/**
 *
 * @author Teodor Todorov
 */
@Data
@Entity(name = "ROLE_T")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(name = "ROLE_NAME")
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<User> users;

    // Without EAGER it will not be able perform User.getAuthorities()
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ROLE_PRIVILEGES", joinColumns = {
        @JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "PRIVILEGE_ID")})
    private List<Privilege> privileges;
}
