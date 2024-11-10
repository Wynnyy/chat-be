package com.patheon.chatty.user;

import com.patheon.chatty.exception.BusinessException;
import com.patheon.chatty.model.dto.UserDto;
import com.patheon.chatty.model.entity.User;
import com.patheon.chatty.model.mapper.impl.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto saveUser(User user) {
        try {
            userRepository.findByNickName(user.getNickName());
        } catch (Exception e) {
            throw new BusinessException("User with this Account already exist.", HttpStatus.NOT_FOUND);

        }
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> user = userRepository.findAll();
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findByName(String nickName) {
        try {
            return userMapper.toDto(userRepository.findByNickName(nickName));
        } catch (Exception e) {
            throw new BusinessException("User with this Account doesn't exist.", HttpStatus.NOT_FOUND);

        }
    }
}
