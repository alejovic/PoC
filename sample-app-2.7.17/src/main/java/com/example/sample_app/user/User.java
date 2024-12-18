package com.example.sample_app.user;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class User {
    @Id
    private Long id;

    private String name;

    private String role;
}
