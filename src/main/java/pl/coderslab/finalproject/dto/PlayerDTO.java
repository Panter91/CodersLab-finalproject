package pl.coderslab.finalproject.dto;


import lombok.Data;
import pl.coderslab.finalproject.entity.Team;

@Data
public class PlayerDTO {

    private Long id;
    private String name;
    private String surname;
    private String team;
    private Integer number;
    private Integer goalsScored;
}
