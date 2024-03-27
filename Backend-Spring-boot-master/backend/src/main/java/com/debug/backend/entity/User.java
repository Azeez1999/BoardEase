package com.debug.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column(unique = true)  // Make email field unique
    private String email;
    private String userName;
    private String password;
    private String DOB;
    private String contactNumber;
    private String gender;
    private String address;
    private String role = "0";
    public String getEmail() {
      return null;
    }
    public Object getPassword() {
      return null;
    }
}

