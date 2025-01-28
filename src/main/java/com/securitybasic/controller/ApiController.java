package com.securitybasic.controller;


import com.securitybasic.model.MyUser;
import com.securitybasic.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String hello() {
        return "Hello, authenticated user!";
    }


    @PostMapping("/register")
    public String registerUser(@RequestBody MyUser user) {
        // Verificar si el usuario ya existe
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return "El nombre de usuario ya está en uso.";
        }

        // Encriptar la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        return "Usuario registrado con éxito.";
    }


}
