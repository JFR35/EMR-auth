package com.securitybasic.service;


import com.securitybasic.dto.UserLoginDTO;
import com.securitybasic.dto.UserRegisterDTO;

public interface AuthService {

    void registerUser(UserRegisterDTO userRegisterDTO);

    UserLoginDTO loginUser(UserLoginDTO userLoginDTO);
}
