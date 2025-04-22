package com.example.demo.role;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RoleController.class)
public class RoleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    RoleService roleService;

    @Test
    public void test() throws Exception {
        //
        RoleDTO role = new RoleDTO();
        role.setId(1L);
        role.setDescription("Role1");
        when(roleService.findById(1L)).thenReturn(role);

        //
        mockMvc.perform(get("/api/v1/roles/1"))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.description").value("Role1"));

        //
        verify(roleService).findById(1L);

    }
}
