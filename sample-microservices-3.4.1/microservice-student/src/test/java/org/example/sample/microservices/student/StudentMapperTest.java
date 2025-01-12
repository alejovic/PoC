package org.example.sample.microservices.student;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentMapperTest {

    @Test
    @DisplayName("Test student mapping 'Entity to DTO'")
    public void test_entity_to_dto() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(1L);
        studentEntity.setFirstName("Jose");
        studentEntity.setLastName("Perez");
        studentEntity.setEmail("test@test.com");
        studentEntity.setStudentNumber("123456");

        StudentDTO dto = StudentMapper.INSTANCE.buildDTO(studentEntity);
        assertEquals(1L, studentEntity.getId());
        assertEquals("Jose", studentEntity.getFirstName());

        assertEquals(studentEntity.getId(), dto.getId());
        assertEquals(studentEntity.getFirstName(), dto.getFirstName());
        assertEquals(studentEntity.getLastName(), dto.getLastName());
        assertEquals(studentEntity.getEmail(), dto.getEmail());
        assertEquals(studentEntity.getStudentNumber(), dto.getStudentNumber());
    }

    @Test
    @DisplayName("Test student mapping 'DTO to Entity'")
    public void test_dto_to_entity() {
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456  ");

        StudentEntity entity = StudentMapper.INSTANCE.buildEntity(studentDTO);

        assertEquals(studentDTO.getId(), entity.getId());
        assertEquals(studentDTO.getFirstName(), entity.getFirstName());
        assertEquals(studentDTO.getLastName(), entity.getLastName());
        assertEquals(studentDTO.getEmail(), entity.getEmail());
        assertEquals(studentDTO.getStudentNumber(), entity.getStudentNumber());
    }

    @Test
    @DisplayName("Test student mapping 'DTO to Entity' no Id")
    public void test_dto_to_entity_no_id() {
        StudentDTO studentDTO = new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456  ");

        StudentEntity entity = StudentMapper.INSTANCE.buildEntityWithoutId(studentDTO);

        assertNull( entity.getId());
        assertEquals(studentDTO.getFirstName(), entity.getFirstName());
        assertEquals(studentDTO.getLastName(), entity.getLastName());
        assertEquals(studentDTO.getEmail(), entity.getEmail());
        assertEquals(studentDTO.getStudentNumber(), entity.getStudentNumber());
    }

}
