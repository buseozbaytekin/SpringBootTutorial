package com.example.backend.service;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.model.User;

import java.util.List;

public interface UserService {

    UserViewDTO getUserById(Long id);

    List<UserViewDTO> getUser();
    //normalde 1 nesne dönüyorduk burada 1'den fazla dönebiliriz bu senaryoda list dönmesi gerekir


    UserViewDTO createUser(UserCreateDTO userCreateDTO);

    }
