package com.example.demo.Entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")          //users isimli tablo
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)     //userId generate etme kısmı
    private Long userId;
    private String name;
    private String lastName;

    public User() {         //constructor
    }

    public User(Long userId, String name, String lastName) {
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
