package sazondelbueno.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sazondelbueno.web.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
