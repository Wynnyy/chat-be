package com.patheon.chatty.model.mapper.impl;

import com.patheon.chatty.model.dto.UserDto;
import com.patheon.chatty.model.entity.User;
import com.patheon.chatty.model.mapper.DtoConvertService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserMapper implements DtoConvertService<UserDto, User> {

    @Override
    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getCreated(),
                entity.getUpdated(),
                entity.getNickName(),
                entity.getStatus()
        );
    }

    @Override
    public List<UserDto> toDto(List<User> entity) {
        return entity.stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }
}
