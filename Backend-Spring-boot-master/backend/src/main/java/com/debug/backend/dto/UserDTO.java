package com.debug.backend.dto;

import lombok.Getter;

@Getter
public class UserDTO {
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Object getPassword() {
      return null;
    }

    public String getEmail() {
      return null;
    }

    // getters and setters
}