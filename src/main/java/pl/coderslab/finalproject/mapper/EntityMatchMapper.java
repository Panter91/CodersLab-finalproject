package pl.coderslab.finalproject.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.finalproject.dto.MatchDTO;
import pl.coderslab.finalproject.entity.Match;
import pl.coderslab.finalproject.repository.TeamRepository;

@Component
public class EntityMatchMapper {

    private TeamRepository teamRepository;

    @Autowired
    public EntityMatchMapper(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Match toEntity(MatchDTO matchDTO){

        Match match = new Match();
        match.setId(matchDTO.getId());
        match.setMatchdayNumber(matchDTO.getMatchdayNumber());
        match.setMatchDate(matchDTO.getMatchDate());
        match.setHostTeam(teamRepository.getTeamByName(matchDTO.getHostTeamName()));
        match.setAwayTeam(teamRepository.getTeamByName(matchDTO.getAwayTeamName()));
        match.setHostTeamGoals(matchDTO.getHostTeamGoals());
        match.setAwayTeamGoals(matchDTO.getAwayTeamGoals());

        return match;
    }
}
