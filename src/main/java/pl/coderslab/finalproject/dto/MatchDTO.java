package pl.coderslab.finalproject.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import pl.coderslab.finalproject.entity.Team;

import java.time.LocalDate;
@Data
public class MatchDTO {

    private Long id;
    private int matchdayNumber;
    private LocalDate matchDate;
    private String hostTeamName;
    private String awayTeamName;
    private Integer hostTeamGoals;
    private Integer awayTeamGoals;
}
