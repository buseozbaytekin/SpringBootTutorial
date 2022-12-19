package com.example.backend.dto;

import lombok.Data;

@Data
public class UserCreateDTO {
    //hangi dataları göndermesini istiyorsak onları gireceğiz
    // hepsini almak zorunda değiliz

    //@Size bu neden olmuyor burada?
    private String firstName;

    private String lastName;

}
