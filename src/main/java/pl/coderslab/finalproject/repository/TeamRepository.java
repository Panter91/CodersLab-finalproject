package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
