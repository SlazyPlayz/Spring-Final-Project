package bg.softuni.springexam.model.dto.recipe;

import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;

import java.time.LocalDateTime;
import java.util.Map;

public record RecipeDTO (

        String name,

        String description,

        Map<IngredientDTO, Double> ingredients,

//        String imageUrl,

        String authorName,

        LocalDateTime created) {

}
