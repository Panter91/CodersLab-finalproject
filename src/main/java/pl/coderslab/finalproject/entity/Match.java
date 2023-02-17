package pl.coderslab.finalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
@Data
public class Match {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private int matchdayNumber;
    private LocalDate matchDate;

    @ManyToOne
    @JoinColumn(name = "hostTeamId")
    private Team hostTeam;

    @ManyToOne
    @JoinColumn(name = "awayTeamId")
    private Team awayTeam;

    private Integer hostTeamGoals;
    private Integer awayTeamGoals;
    private boolean finished;


}
