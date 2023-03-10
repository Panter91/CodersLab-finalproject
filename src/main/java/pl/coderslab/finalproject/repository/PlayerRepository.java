package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.finalproject.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
