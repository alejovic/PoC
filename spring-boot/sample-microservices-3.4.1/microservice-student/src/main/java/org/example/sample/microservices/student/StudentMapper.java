package org.example.sample.microservices.student;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO buildDTO(StudentEntity studentEntity);

    StudentEntity buildEntity(StudentDTO studentDTO);

    @Mapping(target = "id", ignore = true)
    StudentEntity buildEntityWithoutId(StudentDTO studentDTO);

}
