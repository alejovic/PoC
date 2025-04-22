package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserDTO findById(Long id) throws UserNotFound {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new UserNotFound();
        }
        return UserMapper.INSTANCE.buildDTO(userEntity.get());
    }
}
