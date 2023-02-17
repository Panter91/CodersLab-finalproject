package pl.coderslab.finalproject.dto;

import lombok.Data;


@Data
public class TeamSummaryDTO {

    private String team;

    private Integer wins;
    private Integer draws;
    private Integer losses;
    private Integer goalsScored;
    private Integer goalsConceded;
    private Integer goalDifference;
    private Integer points;
}
