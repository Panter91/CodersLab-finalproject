package pl.coderslab.finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teamsummary")
@Data
public class TeamSummary {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Team team;

    private int wins;
    private int draws;
    private int losses;
    private int goalsScored;
    private int goalsConceded;
    private int goalDifference;
    private int points;

}
