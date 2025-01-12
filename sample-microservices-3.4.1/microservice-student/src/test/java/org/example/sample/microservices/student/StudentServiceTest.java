package org.example.sample.microservices.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    private List<StudentEntity> studentEntities;

    @BeforeEach
    public void setUp() {
        studentEntities = List.of(
                new StudentEntity(1L, "Jose", "Perez", "a@a.com", "123456"),
                new StudentEntity(2L, "Maria", "Lopez", "b@b.con", "123457"),
                new StudentEntity(3L, "Juan", "Gomez", "c@c.com", "123458"),
                new StudentEntity(4L, "Ana", "Garcia", "d@d.com", "123459")
        );
    }

    @Test
    @DisplayName("Get All Students")
    public void testGetAllStudents() {
        // given

        // when
        when(studentRepository.findAll()).thenReturn(studentEntities);
        // Act: Call the service method
        List<StudentDTO> lstStudents = studentService.getAllStudents();
        // then
        assertEquals(studentEntities.size(), lstStudents.size());
    }

    @Test
    @DisplayName("Get Student By Id")
    public void testGetStudentById() {
        // given
        StudentEntity studentEntity = studentEntities.get(0);
        // when
        when(studentRepository.findById(1L)).thenReturn(java.util.Optional.of(studentEntity));
        // Act: Call the service method
        StudentDTO studentDTO = studentService.getStudentById(1L);
        // then
        assertEquals(1L, studentDTO.getId());
    }

    @Test
    @DisplayName("Create Student")
    public void testCreateStudent() {
        // given
        StudentEntity saveStudentEntity = new StudentEntity(1L, "Jose", "Perez", "a@a.com", "123456");
        // when
        when(studentRepository.save(any(StudentEntity.class))).thenReturn(saveStudentEntity);
        // Act: Call the service method
        StudentDTO studentDTO = studentService.createStudent(StudentMapper.INSTANCE.buildDTO(saveStudentEntity));
        // then
        assertEquals(1L, studentDTO.getId());
    }

    @Test
    @DisplayName("Update Student")
    public void testUpdateStudent() {
        // given
        StudentEntity saveStudentEntity = new StudentEntity(1L, "Jose", "Perez", "a@a.com", "123456");
        StudentEntity updatedStudentEntity = new StudentEntity(1L, "Jose", "Perez", "b@b.com", "123456");
        // when
        when(studentRepository.findById(1L)).thenReturn(java.util.Optional.of(saveStudentEntity));
        when(studentRepository.save(any(StudentEntity.class))).thenReturn(updatedStudentEntity);
        // Act: Call the service method
        StudentDTO studentDTO = studentService.updateStudent(1L, StudentMapper.INSTANCE.buildDTO(saveStudentEntity));
        // then
        assertEquals("b@b.com", studentDTO.getEmail());
    }
}
