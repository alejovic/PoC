package org.example.sample.microservices.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper.INSTANCE::buildDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        return StudentMapper.INSTANCE.buildDTO(studentRepository.findById(id).get());
    }

    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentRepository.save(StudentMapper.INSTANCE.buildEntityWithoutId(studentDTO));
        return StudentMapper.INSTANCE.buildDTO(studentEntity);
    }

    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        StudentEntity studentEntity = studentRepository.findById(id).get();
        studentEntity.setFirstName(studentDTO.getFirstName());
        studentEntity.setLastName(studentDTO.getLastName());
        studentEntity.setEmail(studentDTO.getEmail());
        studentEntity.setStudentNumber(studentDTO.getStudentNumber());
        return StudentMapper.INSTANCE.buildDTO(studentRepository.save(studentEntity));
    }
}
