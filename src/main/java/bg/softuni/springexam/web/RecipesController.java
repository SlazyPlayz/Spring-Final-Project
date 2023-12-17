package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.dto.recipe.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.recipe.RecipeDTO;
import bg.softuni.springexam.service.IngredientService;
import bg.softuni.springexam.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
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
        ModelAndView modelAndView = new ModelAndView("/recipe/recipes-all");
        modelAndView.addObject("recipes", recipeService.allRecipes());

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/recipe/add-recipe");
        List<IngredientDTO> ingredients = ingredientService.allIngredients();
        modelAndView.addObject("recipeAddBindingModel", RecipeAddBindingModel.empty(ingredients));
        modelAndView.addObject("ingredientsList", ingredients);

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRecipe(RecipeAddBindingModel recipeAddBindingModel) {

        System.out.println("I got here");

        recipeService.addRecipe(recipeAddBindingModel);

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RecipeDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }
}
