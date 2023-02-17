package pl.coderslab.finalproject.dto;
import lombok.Data;
import pl.coderslab.finalproject.entity.Match;

import java.time.LocalDate;
import java.util.List;


@Data
public class TeamDTO {


    private Long id;

    private String name;

    private String city;

    private LocalDate foundationDate;

    private List<Match> homeMatches;

    private List<Match> awayMatches;
}
