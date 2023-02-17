package pl.coderslab.finalproject.mapper;

import pl.coderslab.finalproject.dto.TeamDTO;
import pl.coderslab.finalproject.entity.Team;

public class TeamMapper {

    public static TeamDTO toDto(Team entity){

        TeamDTO teamDto = new TeamDTO();
        teamDto.setName(entity.getName());
        teamDto.setFoundationDate(entity.getFoundationDate());
        teamDto.setCity(entity.getCity());
        return teamDto;

    }

}
