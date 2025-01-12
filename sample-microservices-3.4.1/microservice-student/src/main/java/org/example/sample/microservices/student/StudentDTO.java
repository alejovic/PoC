package org.example.sample.microservices.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Jacksonized
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String studentNumber;



}
