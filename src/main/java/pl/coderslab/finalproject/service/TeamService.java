package pl.coderslab.finalproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.dto.TeamDTO;
import pl.coderslab.finalproject.entity.Team;
import pl.coderslab.finalproject.entity.TeamSummary;
import pl.coderslab.finalproject.mapper.TeamMapper;
import pl.coderslab.finalproject.repository.TeamRepository;
import pl.coderslab.finalproject.repository.TeamSummaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamSummaryRepository teamSummaryRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, TeamSummaryRepository teamSummaryRepository) {
        this.teamRepository = teamRepository;
        this.teamSummaryRepository = teamSummaryRepository;
    }

    public Optional<TeamDTO> get(Long id) {
        return teamRepository.findById(id).map(TeamMapper::toDto);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    @Transactional
    public void save(TeamDTO teamDTO){

        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setFoundationDate(teamDTO.getFoundationDate());
        teamRepository.save(team);
        TeamSummary teamSummary = new TeamSummary();
        teamSummary.setTeam(team);
        teamSummaryRepository.save(teamSummary);

    }
}
