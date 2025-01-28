package com.securitybasic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name",nullable = false,unique = true)
    @Size(min = 3)
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(name = "password",nullable = false)
    @Size(min = 8, message = "La contraseña debe tener al menos 8 chars")
    @NotBlank(message = "Password is mandatory")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}