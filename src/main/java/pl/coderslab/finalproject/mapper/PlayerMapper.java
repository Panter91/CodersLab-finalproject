package pl.coderslab.finalproject.mapper;

import pl.coderslab.finalproject.dto.PlayerDTO;
import pl.coderslab.finalproject.entity.Player;

public class PlayerMapper {

    public static PlayerDTO toDto(Player entity){

        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(entity.getId());
        playerDTO.setName(entity.getName());
        playerDTO.setSurname(entity.getSurname());
        playerDTO.setTeam(entity.getTeam().getName());
        playerDTO.setNumber(entity.getNumber());
        playerDTO.setGoalsScored(entity.getGoalsScored());
        return playerDTO;

    }
}
