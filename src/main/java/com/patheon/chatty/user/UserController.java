package com.patheon.chatty.user;

import com.patheon.chatty.model.dto.UserDto;
import com.patheon.chatty.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.USER)
public class UserController {

    public static final String USER = "/user";
    public static final String NICK_NAME = "/nick";


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping(NICK_NAME)
    public ResponseEntity<UserDto> finUserByName(@RequestParam(name = "nickName") String nickName){
        System.out.println(nickName);
        return ResponseEntity.ok(userService.findByName(nickName));
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.ok(userService.saveUser(user));
    }
}
