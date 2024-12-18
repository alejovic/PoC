package com.example.sample_jpa_27._7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @ManyToMany(targetEntity = Club.class, fetch = jakarta.persistence.FetchType.LAZY, mappedBy = "tournaments")
    private List<Club> clubs;

}
