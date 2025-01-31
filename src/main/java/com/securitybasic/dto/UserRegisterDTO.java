package com.securitybasic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {
    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, message = "El nombre de usuario debe tener al menos 3 caracteres.")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres.")
    private String password;

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
