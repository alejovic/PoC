package com.example.sample_app;

import com.example.sample_app.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    UserService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetById() throws Exception {
        UserDTO user = new UserDTO().withIdentifier(1L).withName("Boots");

        when(service.findById(1)).thenReturn(user);

        ResultActions result = mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Boots"));

        verify(service).findById(1);

    }

    @Test
    public void testGetByIdNotFound() throws Exception {
        when(service.findById(1)).thenThrow(new UserNotFoundException());
        ResultActions result = mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isNotFound());
        verify(service).findById(1);

    }
}
