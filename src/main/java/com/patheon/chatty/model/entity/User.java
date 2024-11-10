package com.patheon.chatty.model.entity;

import com.patheon.chatty.model.enums.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "nick_name", length = 30, unique = true, nullable = false)
    private String nickName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private Status status;

    public User() {
    }

    public User(Long id, LocalDateTime created, LocalDateTime updated, String nickName, Status status) {
        super(id, created, updated);
        this.nickName = nickName;
        this.status = status;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!Objects.equals(nickName, user.nickName)) return false;
        return status == user.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", status=" + status +
                '}';
    }
}
