package com.example.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//Bu userUpdateDto değişmesine izin verilen bilgileri göstermektedir.
//Değişemez valuelar yalnızca userCreateDto üzerinde gösterilir.
@Data
public class UserUpdateDto {
    @NotNull(message = "{backend.constraints.firstname.NotNull.message}")
    @Size(min = 2, max = 32, message = "{backend.constraints.firstname.Size.message}")
    private String firstName;

    @NotNull(message = "{backend.constraints.lastname.NotNull.message}")
    @Size(min = 3, max = 32, message = "{backend.constraints.lastname.Size.message}")
    private String lastName;

}
