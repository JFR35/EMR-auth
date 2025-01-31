package com.securitybasic.mapper;

import com.securitybasic.dto.UserLoginDTO;
import com.securitybasic.dto.UserRegisterDTO;
import com.securitybasic.model.MyUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    MyUser toEntity(UserLoginDTO userLoginDTO);

    UserLoginDTO toDto(MyUser user);

    MyUser toEntity(UserRegisterDTO userRegisterDTO);
}

