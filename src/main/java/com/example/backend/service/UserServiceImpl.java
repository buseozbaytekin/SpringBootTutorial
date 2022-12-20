package com.example.backend.service;

import com.example.backend.dto.UserCreateDTO;
import com.example.backend.dto.UserUpdateDto;
import com.example.backend.dto.UserViewDTO;
import com.example.backend.exception.NotFoundException;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
//direkt repository'e ulaşıp getById ile işlemler yapılacak
    private final UserRepository userRepository;

    //burada DTO kullanıcıya açılmasını istemediğimiz -mesela password- gibi değişkenleri gizlemek,
    //ya da entitiy üzerinden çalışmak istemedğimiz bağımlılık ordan oraya sürüklenmesin diye kullanılır.
    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found exception"));
        return UserViewDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    //transaction işlemi olmadığı için readOnly true yaptık
    public List<UserViewDTO> getUser() {
        return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
    }

    @Override
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        //bu save bizim için otomatik olarak runtime da save işlemi yapacak
        final User user = userRepository.save
                (new User(userCreateDTO.getFirstName(),userCreateDTO.getLastName()));

        return UserViewDTO.of(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDto userUpdateDto) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        user.setFirstName(userUpdateDto.getFirstName());
        user.setLastName(userUpdateDto.getLastName());
        final User updatedUser = userRepository.save(user);
        return UserViewDTO.of(updatedUser);
    }
}
