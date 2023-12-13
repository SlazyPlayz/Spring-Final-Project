package bg.softuni.springexam.model.dto;

import bg.softuni.springexam.model.enums.DietaryRestriction;

import java.util.Set;

public record RecipeIngredientDTO (

        String name,

        int amount
) {
    public static RecipeIngredientDTO empty() {
        return new RecipeIngredientDTO(null, 0);
    }
}
