package sazondelbueno.web.Service;

import sazondelbueno.web.Model.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);

    List<Recipe> listRecipes();

    Optional<Recipe> getById(Long id);

    boolean deleteById(Long id);

    Recipe updateById(Long id, Recipe recipe);
}
