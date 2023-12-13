package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.IngredientDTO;
import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;
import bg.softuni.springexam.model.dto.RecipeIngredientDTO;
import bg.softuni.springexam.model.entity.RecipeEntity;
import bg.softuni.springexam.service.IngredientService;
import bg.softuni.springexam.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/recipes")
public class RecipesController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private RecipeAddBindingModel recipeAddBindingModel;

    public RecipesController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        recipeAddBindingModel = RecipeAddBindingModel.empty();
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
        modelAndView.addObject("recipeAddBindingModel", recipeAddBindingModel);
        modelAndView.addObject("ingredientDTO", RecipeIngredientDTO.empty());
        modelAndView.addObject("ingredients", ingredientService.allIngredients());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addRecipe() {

        recipeService.addRecipe(recipeAddBindingModel);

        return new ModelAndView("index");
    }

    @PostMapping("/recipes/add-ingredient")
    public void addIngredient(RecipeIngredientDTO ingredient) {
        recipeAddBindingModel.addIngredient(ingredient);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RecipeDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(recipeService.findById(id));
    }
}
