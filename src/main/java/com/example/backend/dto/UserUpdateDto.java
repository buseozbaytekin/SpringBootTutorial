package com.example.backend.dto;

import lombok.Data;

//Bu userUpdateDto değişmesine izin verilen bilgileri göstermektedir.
//Değişemez valuelar yalnızca userCreateDto üzerinde gösterilir.
@Data
public class UserUpdateDto {
    private String firstName;
    private String lastName;

}
