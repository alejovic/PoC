package com.example.sample_app;

import com.example.sample_app.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @Test
    public void getCatById() throws Exception {

        Optional<User> user = Optional.of(new User().withId(1L).withName("Boots"));

        when(repository.findById(1L)).thenReturn(user);

        UserService service = new UserService(repository);
        UserDTO foundUser = service.findById(1);
        assertThat(foundUser.getIdentifier()).isEqualTo(user.get().getId());

        verify(repository).findById(1L);

    }

    @Test
    public void getCatByIdNotFound() {
        UserService service = new UserService(repository);
        Optional<User> user = Optional.empty();
        when(repository.findById(1L)).thenReturn(user);
        assertThrows(UserNotFoundException.class, () -> {
            UserDTO foundUser = service.findById(1);
        });

        verify(repository).findById(1L);
    }

}
