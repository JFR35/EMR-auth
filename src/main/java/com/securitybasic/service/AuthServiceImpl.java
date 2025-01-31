package com.securitybasic.service;

import com.securitybasic.dto.UserLoginDTO;
import com.securitybasic.dto.UserRegisterDTO;
import com.securitybasic.mapper.UserMapper;
import com.securitybasic.model.MyUser;
import com.securitybasic.repository.UserRepository;
import com.securitybasic.service.exception.UserAlreadyExistsException;
import com.securitybasic.service.exception.UsernameNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public void registerUser(@Valid UserRegisterDTO userRegisterDTO) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("El nombre de usuario ya está en uso");
        }
        MyUser user = userMapper.toEntity(userRegisterDTO);
        String encodedPassword = passwordEncoder.encode(userRegisterDTO.getPassword());
        user.setPassword(encodedPassword); // Encriptar contraseña
        userRepository.save(user);
        logger.debug("User registered: {} with encoded password: {}", user.getUsername(), encodedPassword);
    }

    @Override
    public UserLoginDTO loginUser(@Valid UserLoginDTO userLoginDTO) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(userLoginDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        logger.debug("User found: {}", user.getUsername());
        logger.debug("Encoded password in DB: {}", user.getPassword());
        if (!passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            logger.debug("Password mismatch for user: {}", userLoginDTO.getUsername());
            throw new IllegalArgumentException("Contraseña incorrecta para el usuario: " + userLoginDTO.getUsername());
        }
        logger.debug("User logged in successfully: {}", userLoginDTO.getUsername());
        return userLoginDTO;
    }
}
