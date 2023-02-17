package pl.coderslab.finalproject.mapper;

import pl.coderslab.finalproject.dto.MatchDTO;
import pl.coderslab.finalproject.entity.Match;

public class MatchMapper {

    public static MatchDTO toDto(Match entity){

        MatchDTO matchDto = new MatchDTO();
        matchDto.setId(entity.getId());
        matchDto.setMatchdayNumber(entity.getMatchdayNumber());
        matchDto.setMatchDate(entity.getMatchDate());
        matchDto.setHostTeamName(entity.getHostTeam().getName());
        matchDto.setAwayTeamName(entity.getAwayTeam().getName());
        matchDto.setHostTeamGoals(entity.getHostTeamGoals());
        matchDto.setAwayTeamGoals(entity.getAwayTeamGoals());
        return matchDto;

    }
}
