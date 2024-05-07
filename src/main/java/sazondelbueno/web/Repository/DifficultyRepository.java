package sazondelbueno.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sazondelbueno.web.Model.Difficulty;

public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
