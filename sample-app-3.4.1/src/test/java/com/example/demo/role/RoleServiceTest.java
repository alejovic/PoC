package com.example.demo.role;

import com.example.demo.user.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @InjectMocks
    RoleService roleService;

    @Mock
    RoleRepository roleRepository;

    @Test
    public void test(){
        //
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(1L);
        roleEntity.setDescription("Role1");
        when(roleRepository.findById(1L)).thenReturn(Optional.ofNullable(roleEntity));

        //
        RoleDTO roleDTO = roleService.findById(1L);
        //
        assertNotNull(roleDTO);
        assertEquals(roleDTO.getId(), roleEntity.getId());

    }
}
