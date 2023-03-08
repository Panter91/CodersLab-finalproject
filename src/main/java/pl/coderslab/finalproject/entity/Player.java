package pl.coderslab.finalproject.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@Table(name = "players")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @ManyToOne
    @JoinColumn(name = "teamId")
    private Team team;

    private Integer number;

    private Integer goalsScored;

}
