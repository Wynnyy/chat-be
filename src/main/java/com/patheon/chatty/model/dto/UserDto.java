package com.patheon.chatty.model.dto;

import com.patheon.chatty.model.enums.Status;

import java.time.LocalDateTime;

public class UserDto extends BaseEntityDto {

    private String fullName;
    private Status status;

    public UserDto(Long id, LocalDateTime created, LocalDateTime updated, String fullName, Status status) {
        super(id, created, updated);
        this.fullName = fullName;
        this.status = status;
    }

    public UserDto() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
