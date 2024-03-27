package com.debug.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String feedBack;

    @Column(unique = true)
    private String userID;

    public Object getFeedBack() {
      return null;
    }

    public void setFeedBack(Object feedBack2) {
    }
}
