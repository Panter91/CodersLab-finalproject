package pl.coderslab.finalproject.mapper;

import pl.coderslab.finalproject.dto.TeamSummaryDTO;
import pl.coderslab.finalproject.entity.TeamSummary;

public class TeamSummaryMapper {

    public static TeamSummaryDTO toDto(TeamSummary entity){

        TeamSummaryDTO teamSummaryDTO = new TeamSummaryDTO();
        teamSummaryDTO.setTeam(entity.getTeam().getName());
        teamSummaryDTO.setWins(entity.getWins());
        teamSummaryDTO.setDraws(entity.getDraws());
        teamSummaryDTO.setLosses(entity.getLosses());
        teamSummaryDTO.setGoalsScored(entity.getGoalsScored());
        teamSummaryDTO.setGoalsConceded(entity.getGoalsConceded());
        teamSummaryDTO.setGoalDifference(entity.getGoalDifference());
        teamSummaryDTO.setPoints(entity.getPoints());
        return teamSummaryDTO;

    }
}
