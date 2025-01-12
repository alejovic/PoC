package org.example.sample.microservices.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;

    @MockitoBean
    private StudentService studentService;

    private ObjectMapper om;
    private List<StudentDTO> studentDtos;

    @BeforeEach
    public void setUp() {
        om = new ObjectMapper();

        studentDtos = List.of(
                new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456"),
                new StudentDTO(2L, "Maria", "Lopez", "b@b.con", "123457"),
                new StudentDTO(3L, "Juan", "Gomez", "c@c.com", "123458"),
                new StudentDTO(4L, "Ana", "Garcia", "d@d.com", "123459")
        );
    }

    @Test
    @DisplayName("Test find all students")
    public void test_find_all() throws Exception {
        // when
        when(studentService.getAllStudents()).thenReturn(studentDtos);
        // Act: Perform GET request
        mockMvc.perform(get("/api/v1/students")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(studentDtos.size())) // Assert array size is 4
                .andExpect(jsonPath("$[0].id").value(1)) // First student's ID
                .andExpect(jsonPath("$[0].firstName").value("Jose")) // First student's firstName
                .andExpect(jsonPath("$[0].lastName").value("Perez")) // First student's lastName
                .andExpect(jsonPath("$[0].email").value("a@a.com")); // First student's email
        verify(studentService).getAllStudents();

    }

    @Test
    @DisplayName("Test find student by id")
    public void test_find_by_id() throws Exception {
        StudentDTO dto = new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456");
        // when
        when(studentService.getStudentById(1L)).thenReturn(dto);
        // Act: Perform GET request
        mockMvc.perform(get("/api/v1/students/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Jose"))
                .andExpect(jsonPath("$.email").value("a@a.com"));
        verify(studentService).getStudentById(1L);
    }

    @Test
    @DisplayName("Test create student")
    public void test_create() throws Exception {
        StudentDTO dto = new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456");
        String json = om.writeValueAsString(dto);
        // when
        when(studentService.createStudent(any(StudentDTO.class))).thenReturn(dto);
        // Act: Perform POST request
        mockMvc.perform(post("/api/v1/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Jose"))
                .andExpect(jsonPath("$.email").value("a@a.com"));
        verify(studentService).createStudent(any(StudentDTO.class));
    }

    @Test
    @DisplayName("Test update student")
    public void test_update() throws Exception {
        StudentDTO dto = new StudentDTO(1L, "Jose", "Perez", "a@a.com", "123456");
        StudentDTO updatedDto = new StudentDTO(1L, "Jose", "Perez", "b@b.com", "123456");
        String json = om.writeValueAsString(dto);
        // when
        when(studentService.updateStudent(eq(1L), any(StudentDTO.class))).thenReturn(updatedDto);
        // Act: Perform PUT request
        mockMvc.perform(put("/api/v1/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Jose"))
                .andExpect(jsonPath("$.email").value("b@b.com"));
        verify(studentService).updateStudent(eq(1L), any(StudentDTO.class));
    }

}
