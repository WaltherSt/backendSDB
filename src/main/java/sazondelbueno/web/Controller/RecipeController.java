package sazondelbueno.web.Controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sazondelbueno.web.Model.Recipe;
import sazondelbueno.web.Service.RecipeService;

@Controller
@RequestMapping("/recipe")
@CrossOrigin("*")
public class RecipeController {

    @Autowired
	RecipeService recipeService;

    @PostMapping()
    public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe r){
        Recipe recipe = recipeService.saveRecipe(r);
        return new ResponseEntity<>(recipe,HttpStatus.CREATED);
    }

    @GetMapping()
	public ResponseEntity<List<Recipe> > getRecipes(){
		List<Recipe> lista = recipeService.listRecipes();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

    @GetMapping("/{id}")
	public ResponseEntity<Optional<Recipe>>getById(@PathVariable("id") Long id){
		Optional<Recipe> r = recipeService.getById(id);
		return  new ResponseEntity<>(r,HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean>deleteById(@PathVariable("id") Long id){
		boolean exit = recipeService.deleteById(id);
		return  new ResponseEntity<>(exit,HttpStatus.OK);
	}

	@SuppressWarnings("null")
	@PatchMapping("/{id}")
	public ResponseEntity<Recipe> updateReceta (@RequestBody Recipe recipe, @PathVariable Long id){
		try {
			return new ResponseEntity<>(recipeService.updateById(id, recipe), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
