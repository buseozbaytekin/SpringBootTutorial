package com.example.backend.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public final class GenericResponse {
//Burada kullanıcıya başarılı bir şekilde kayıt oluştu ya da
// bilgileri eksik girdiniz mesajı dönecek.
    private String message;


}
