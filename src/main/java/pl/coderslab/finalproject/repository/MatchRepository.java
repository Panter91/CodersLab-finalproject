package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.entity.Match;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query("SELECT m FROM Match m JOIN FETCH m.hostTeam ht JOIN FETCH m.awayTeam at WHERE m.finished = :finished ORDER BY m.id")
    List<Match> findAllByFinished(boolean finished);
}
