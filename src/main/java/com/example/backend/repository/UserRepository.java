package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    //boolean dönüş tipiyle Ali isimli kullanıcı var mı bak. kontrol ediyor varsa true yoksa false dönüyor. userbyusername spring datanın özelliği.
    //
    boolean existsUserByUsername(String username);

}
