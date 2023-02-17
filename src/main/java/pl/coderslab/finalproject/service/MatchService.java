package pl.coderslab.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.dto.MatchDTO;
import pl.coderslab.finalproject.dto.MatchResultDTO;
import pl.coderslab.finalproject.dto.TeamDTO;
import pl.coderslab.finalproject.entity.Match;
import pl.coderslab.finalproject.entity.Team;
import pl.coderslab.finalproject.entity.TeamSummary;
import pl.coderslab.finalproject.mapper.EntityMatchMapper;
import pl.coderslab.finalproject.mapper.MatchMapper;
import pl.coderslab.finalproject.mapper.TeamMapper;
import pl.coderslab.finalproject.repository.MatchRepository;
import pl.coderslab.finalproject.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final EntityMatchMapper entityMatchMapper;

    @Autowired
    public MatchService(MatchRepository matchRepository, TeamRepository teamRepository, EntityMatchMapper entityMatchMapper) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
        this.entityMatchMapper = entityMatchMapper;
    }

    public Map<Integer,List<MatchDTO>> findAllByFinished(boolean finished) {
        return matchRepository.findAllByFinished(finished).stream()
                .map(MatchMapper::toDto)
                .collect(Collectors.groupingBy(matchDTO -> matchDTO.getMatchdayNumber()));
    }

//    public List<MatchDTO> findAllByFinished(boolean finished) {
//        return matchRepository.findAllByFinished(finished).stream().map(MatchMapper::toDto).toList();
//    }
    public MatchDTO findMatchById(Long id) {
        return matchRepository.findById(id).map(MatchMapper::toDto).orElseThrow();
    }

    public int saveMatch(MatchDTO matchDTO){

        Long id = matchDTO.getId();
        Match match = matchRepository.findById(id).get();
        if(match.isFinished()){
            return -1;
        }
        match.setHostTeamGoals(matchDTO.getHostTeamGoals());
        match.setAwayTeamGoals(matchDTO.getAwayTeamGoals());
        match.setFinished(true);
        matchRepository.save(match);
        return 1;
//        matchRepository.save(entityMatchMapper.toEntity(matchDTO));
    }

    @Transactional
    public void updateresult(MatchDTO matchDTO) {

        matchRepository.findById(matchDTO.getId()).ifPresent(match -> {
            if (!match.isFinished()){

                match.setHostTeamGoals(matchDTO.getHostTeamGoals());
                match.setAwayTeamGoals(matchDTO.getAwayTeamGoals());
                TeamSummary hometeam = match.getHostTeam().getTeamSummary();
                TeamSummary awayteam = match.getAwayTeam().getTeamSummary();
                hometeam.setGoalsScored(matchDTO.getHostTeamGoals() + hometeam.getGoalsScored());
                hometeam.setGoalsConceded(matchDTO.getAwayTeamGoals() + hometeam.getGoalsConceded());
                awayteam.setGoalsScored(matchDTO.getAwayTeamGoals() + awayteam.getGoalsScored());
                awayteam.setGoalsConceded(matchDTO.getHostTeamGoals() + awayteam.getGoalsConceded());
                hometeam.setGoalDifference(hometeam.getGoalsScored() - hometeam.getGoalsConceded());
                awayteam.setGoalDifference(awayteam.getGoalsScored() - awayteam.getGoalsConceded());
                if ( matchDTO.getHostTeamGoals() > matchDTO.getAwayTeamGoals() ) {
                   hometeam.setWins(hometeam.getWins() + 1);
                   hometeam.setPoints(hometeam.getPoints() + 3);
                   awayteam.setLosses(awayteam.getLosses() + 1);
                } else if (matchDTO.getHostTeamGoals() < matchDTO.getAwayTeamGoals()) {
                    awayteam.setWins(awayteam.getWins() + 1);
                    awayteam.setPoints(awayteam.getPoints() + 3);
                    hometeam.setLosses(hometeam.getLosses()+ 1);
                } else {
                    hometeam.setDraws(hometeam.getDraws() + 1);
                    awayteam.setDraws(awayteam.getDraws() + 1);
                }
                match.setFinished(true);

            }

        });

    }
    public void generateSchedule(){
        schedule(teamRepository.findAll());
    }

    public void schedule(List<Team> list){

        List<Match> matches = new ArrayList<>();

        for (int round = 0; round < (list.size()-1)*2; round++) {
            for (int match = 0; match < (list.size() / 2); match++) {
                Match game = new Match();
                game.setMatchdayNumber(round + 1);

                game.setHostTeam(list.get((round + match) % (list.size() - 1)));
                game.setAwayTeam(list.get((list.size() - 1 - match + round) % (list.size() - 1)));

                // Last team stays in the same place while the others rotate around it.
                if (match == 0) {
                    game.setAwayTeam(list.get(list.size() - 1));
                }
                matches.add(game);
            }

        }

        matchRepository.saveAll(matches);
    }
}
