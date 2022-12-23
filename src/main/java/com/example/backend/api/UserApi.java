package com.example.backend.api;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserUpdateDto;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.service.UserService;
import com.example.backend.util.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//burada projede gelecek tüm istekler handle edilmektedir.
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @GetMapping("v1/user/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
        final UserViewDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("v1/user")
    public ResponseEntity<List<UserViewDTO>> getUsers(){
        final List<UserViewDTO> users = userService.getUser();
        return ResponseEntity.ok(users);
    }

    @PostMapping("v1/user")
    public ResponseEntity<?> createUser(@RequestBody UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return ResponseEntity.ok(new GenericResponse("User created!"));
    }

    @PutMapping("v1/user/{id}")//iki path aynı olabilir çünkü annotations farklı
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto){
        final UserViewDTO user = userService.updateUser(id, userUpdateDto);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("v1/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(new GenericResponse("User deleted!"));
    }

    @GetMapping("v1/user/slice")
    public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable){
        final List<UserViewDTO> users = userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

}


