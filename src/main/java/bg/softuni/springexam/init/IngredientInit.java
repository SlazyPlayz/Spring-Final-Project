package bg.softuni.springexam.init;

import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.service.IngredientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IngredientInit
        implements CommandLineRunner
{

    private final IngredientService ingredientService;

    public IngredientInit(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        ingredientService.addIngredient(new IngredientEntity().setName("cucumber"));
        ingredientService.addIngredient(new IngredientEntity().setName("potato"));
        ingredientService.addIngredient(new IngredientEntity().setName("tomato"));
        ingredientService.addIngredient(new IngredientEntity().setName("apple"));
    }
}
