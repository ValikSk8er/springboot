package com.valiksk8.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    //mappedBy = "users" вказуэться імя поля в протилежному класі
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String email, String password, String verifiedPassword, String token, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


//    public static User of(RegisterUserDto userDto) {
//        User user = new User();
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setToken(userDto.getToken());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        return user;
//    }
}
