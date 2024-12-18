package com.example.sample_jpa_27._7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(targetEntity = Club.class)
    @JoinColumn(name = "club_fk_id")
    private Club club;

}
