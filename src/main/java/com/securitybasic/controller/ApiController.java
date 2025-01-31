package com.securitybasic.controller;

import com.securitybasic.dto.UserLoginDTO;
import com.securitybasic.dto.UserRegisterDTO;
import com.securitybasic.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final AuthService authService;

    public ApiController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        try {
            UserLoginDTO userResponse = authService.loginUser(userLoginDTO);
            return ResponseEntity.ok("Usuario logueado correctamente. Token: " + userResponse.getUsername());
        } catch (IllegalArgumentException error) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
        // LLamar al servicio para registar al usuario
        authService.registerUser(userRegisterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");
    }
}
