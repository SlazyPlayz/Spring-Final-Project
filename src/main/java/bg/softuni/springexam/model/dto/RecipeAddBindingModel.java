package bg.softuni.springexam.model.dto;

import java.util.*;

public record RecipeAddBindingModel(
        String name,

        String description,

        List<RecipeIngredientDTO> ingredients,

        String imageUrl) {


    public static RecipeAddBindingModel empty() {
        return new RecipeAddBindingModel(null, null, new ArrayList<>(), null);
    }

    public RecipeAddBindingModel addIngredient(RecipeIngredientDTO ingredientDTO) {
        ingredients.add(ingredientDTO);
        return this;
    }
}
