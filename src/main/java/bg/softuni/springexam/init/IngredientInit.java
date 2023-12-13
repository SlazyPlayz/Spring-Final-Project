package bg.softuni.springexam.init;

import bg.softuni.springexam.service.IngredientService;
import bg.softuni.springexam.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredientInit
        implements CommandLineRunner
{

    private final IngredientService ingredientService;
    private final RecipeService recipeService;

    public IngredientInit(IngredientService ingredientService, RecipeService recipeService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {
//        ingredientService.addIngredient(new IngredientEntity().setName("cucumber"));
//        ingredientService.addIngredient(new IngredientEntity().setName("potato"));
//        ingredientService.addIngredient(new IngredientEntity().setName("tomato"));
//        ingredientService.addIngredient(new IngredientEntity().setName("apple"));
//
//        recipeService.addRecipe(new RecipeAddBindingModel(
//                UUID.randomUUID(),
//                "A name",
//                "A description",
//                Set.of(
//                        new RecipeIngredientDTO("cucumber", 120, new HashSet<>()),
//                                new RecipeIngredientDTO("tomato", 160, new HashSet<>())
//                ),
//                ""));
//        recipeService.addRecipe(new RecipeAddBindingModel(
//                UUID.randomUUID(),
//                "Another name",
//                "Another description",
//                Set.of(
//                        new RecipeIngredientDTO("potato", 150, new HashSet<>()),
//                        new RecipeIngredientDTO("apple", 170, new HashSet<>())
//                ),
//                ""));
    }
}
