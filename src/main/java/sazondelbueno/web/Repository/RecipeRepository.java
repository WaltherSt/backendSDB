package sazondelbueno.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sazondelbueno.web.Model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
