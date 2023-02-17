package pl.coderslab.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.dto.TeamSummaryDTO;
import pl.coderslab.finalproject.mapper.TeamSummaryMapper;
import pl.coderslab.finalproject.repository.TeamSummaryRepository;

import java.util.List;
@Service
public class TeamSummaryService {

    private TeamSummaryRepository teamSummaryRepository;

    @Autowired
    public TeamSummaryService(TeamSummaryRepository teamSummaryRepository) {
        this.teamSummaryRepository = teamSummaryRepository;
    }

    public List<TeamSummaryDTO> find() {
        return teamSummaryRepository.findAll(Sort.by(Sort.Direction.DESC,"points","goalDifference","goalsScored")).stream().map(TeamSummaryMapper::toDto).toList();
    }
}
