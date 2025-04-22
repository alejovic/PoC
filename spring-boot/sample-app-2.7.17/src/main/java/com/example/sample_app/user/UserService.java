package com.example.sample_app.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository catRepository) {
        this.repository = catRepository;
    }

    public UserDTO findById(long id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException();
        }
        UserDTO userDTO = UserDTOMapper.INSTANCE.userToUserDTO(user.get());
        return userDTO;
    }
}
