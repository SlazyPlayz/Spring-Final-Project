package bg.softuni.springexam.model.dto;

import java.time.LocalDateTime;
import java.util.Map;

public record RecipeDTO (

        String name,

        String description,

        Map<IngredientDTO, Integer> ingredients,

        String imageUrl,

        String authorName,

        LocalDateTime created) {

}
