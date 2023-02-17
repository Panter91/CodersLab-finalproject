package pl.coderslab.finalproject.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    private String city;

    @OneToOne(mappedBy = "team", fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private TeamSummary teamSummary;

    @NonNull
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "hostTeam")
    private Set<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam")
    private Set<Match> awayMatches;

}
