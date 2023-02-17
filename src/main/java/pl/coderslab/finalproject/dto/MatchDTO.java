package pl.coderslab.finalproject.dto;

import lombok.Data;

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
