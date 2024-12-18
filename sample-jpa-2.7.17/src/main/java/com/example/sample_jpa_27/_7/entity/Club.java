package com.example.sample_jpa_27._7.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(targetEntity = Coach.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_fk_id")
    private Coach coach;

    @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
    private List<Player> players;

    @ManyToOne(targetEntity = FootballAssociation.class)
    @JoinColumn(name = "football_association_fk_id")
    private FootballAssociation footballAssociation;

    @ManyToMany(targetEntity = Tournament.class, fetch = FetchType.LAZY)
    private List<Tournament> tournaments;

}
