package sazondelbueno.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sazondelbueno.web.Model.Favorite;

public interface FavoriteRepository  extends JpaRepository<Favorite,Long> {
}
