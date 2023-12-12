package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;
import bg.softuni.springexam.service.IngredientService;
import bg.softuni.springexam.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipesController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public RecipesController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.allRecipes());
    }

    @GetMapping("/all")
    public ModelAndView all() {
        return new ModelAndView("/recipe/recipes-all");
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/recipe/add-recipe");
        modelAndView.addObject("recipeAddBindingModel", RecipeAddBindingModel.empty());
        modelAndView.addObject("ingredients", ingredientService.allIngredients());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(RecipeAddBindingModel recipeAddBindingModel) {

        recipeService.addRecipe(recipeAddBindingModel);

        return new ModelAndView("index");
    }
}
