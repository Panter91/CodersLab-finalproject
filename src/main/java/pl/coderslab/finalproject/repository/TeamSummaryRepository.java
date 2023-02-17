package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.TeamSummary;

public interface TeamSummaryRepository extends JpaRepository<TeamSummary, Long> {
}
