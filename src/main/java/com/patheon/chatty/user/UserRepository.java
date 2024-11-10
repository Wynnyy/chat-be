package com.patheon.chatty.user;

import com.patheon.chatty.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByNickName(String nickName);
}
