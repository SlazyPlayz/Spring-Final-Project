package bg.softuni.springexam.model.dto;

import java.util.Set;

public record RecipeAddBindingModel(

        String name,

        String description,

        Set<RecipeIngredientDTO> ingredients,

        String imageUrl) {

    public static RecipeAddBindingModel empty() {
        return new RecipeAddBindingModel(null, null, null, null);
    }
}
