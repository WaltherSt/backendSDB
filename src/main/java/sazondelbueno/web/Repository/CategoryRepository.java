package sazondelbueno.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sazondelbueno.web.Model.Category;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
