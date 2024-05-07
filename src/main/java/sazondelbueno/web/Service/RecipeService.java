package sazondelbueno.web.Service;
import java.util.List;

import java.util.Optional;


import sazondelbueno.web.Model.Recipe;

public interface RecipeService {
    Recipe saveRecipe(Recipe recipe);
    List<Recipe> listRecipes();
    Optional<Recipe> getById(Long id);
	boolean deleteById(Long id);
    Recipe updateById(Long id, Recipe recipe);
}
