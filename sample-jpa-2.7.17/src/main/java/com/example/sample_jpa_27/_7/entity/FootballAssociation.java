package com.example.sample_jpa_27._7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FootballAssociation {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private String president;
    private String vicePresident;
    private String treasurer;
    private String secretary;

    @OneToMany(targetEntity = Club.class, fetch = FetchType.LAZY, mappedBy = "footballAssociation")
    private List<Club> clubs;

}
