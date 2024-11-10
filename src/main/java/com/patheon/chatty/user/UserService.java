package com.patheon.chatty.user;

import com.patheon.chatty.model.dto.UserDto;
import com.patheon.chatty.model.entity.User;

import java.util.List;

public interface UserService {

    UserDto saveUser(User user);
    List<UserDto> findAllUsers();

    UserDto findByName(String nickName);
}
