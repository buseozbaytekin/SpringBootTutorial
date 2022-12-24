package com.example.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserCreateDTO {
    //hangi dataları göndermesini istiyorsak onları gireceğiz
    // hepsini almak zorunda değiliz

    @NotNull(message = "{backend.constraints.firstName.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.firstName.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastName.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.lastName.Size.message}")
    private String lastName;

}
