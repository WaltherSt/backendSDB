package sazondelbueno.web.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sazondelbueno.web.Model.Recipe;
import sazondelbueno.web.Repository.RecipeRepository;


@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> listRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> getById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            recipeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Recipe updateById(Long id, Recipe recipe) {
        Recipe r = recipeRepository.getReferenceById(id);
        BeanUtils.copyProperties(recipe, r, "id");
        return recipeRepository.save(r);
    }



    
} 
