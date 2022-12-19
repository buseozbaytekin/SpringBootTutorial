package com.example.backend.dto;

import com.example.backend.model.User;
import lombok.Getter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.io.Serializable;

@Getter
public final class UserViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;

    private UserViewDTO(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
//constructor final olduğu için davranış oluşturmamız gerekiyor.
// bu davranış of metodu ile sağlandı. Entity veritabanındaki name i alıp nesne oluşturuldu.
    public static UserViewDTO of(User user){
        return new UserViewDTO(user.getFirstName(), user.getLastName());
    }
}
