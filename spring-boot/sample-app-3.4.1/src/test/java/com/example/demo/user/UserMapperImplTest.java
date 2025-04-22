package com.example.demo.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperImplTest {

    @Test
    @DisplayName("Test user mapping")
    public void test(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("Jose");

        UserDTO dto = UserMapper.INSTANCE.buildDTO(userEntity);
        assertEquals(1L, userEntity.getId());
        assertEquals("Jose", userEntity.getName());
        assertEquals(userEntity.getId(), dto.getId());
        assertEquals(userEntity.getName(), dto.getName());

    }
}
