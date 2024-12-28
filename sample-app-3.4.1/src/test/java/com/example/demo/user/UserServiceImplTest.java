package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void test() throws UserNotFound {
        //given

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Name");
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(userEntity));

        //when
        UserDTO userFound = userService.findById(1L);
        //assert
        assertNotNull(userFound);
        assertEquals(1l, userFound.getId());
        assertEquals("Name", userFound.getName());

    }

    @Test
    public void testNotFound() throws UserNotFound {
        //given
        Optional<UserEntity> userEntity = Optional.empty();
        //when
        when(userRepository.findById(1L)).thenReturn( userEntity);

        //then
        Executable executable =  () -> {
            UserDTO foundUser = userService.findById(1L);
        };
        //assert
        assertThrows(UserNotFound.class, executable);


    }
}
