package com.example.demo.role;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoleMappingImplTest {

    @Test
    @DisplayName("Role Mapping Test")
    public void test(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(2L);
        roleEntity.setDescription("Description");

        RoleDTO roleDTO = RoleMapper.INSTANCE.buildDTO(roleEntity);

        assertNotNull(roleDTO);
        assertEquals(roleDTO.getId(), roleEntity.getId());
    }


}
