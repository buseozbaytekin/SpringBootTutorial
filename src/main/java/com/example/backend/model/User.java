package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false,length = 50,unique = true)
    private String username;
    @Column(name = "first_name", nullable = false, length = 50) //veritabanında nasıl tutulacağını gösteriyor
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    public User(String username, String firstName,String lastName){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
