/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.detail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Teodor Todorov
 */
@Entity(name = "PRIVILEGE_T")
public class Privilege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRIVILEGE_ID")
    private Long id;

    @Column(name = "PRIVILEGE_NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "privileges")
    @JsonIgnore
    private List<Role> role;

    @Override
    public String getAuthority() {
        return name;
    }
}
