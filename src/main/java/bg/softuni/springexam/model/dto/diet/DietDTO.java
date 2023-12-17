package bg.softuni.springexam.model.dto.diet;

import bg.softuni.springexam.model.dto.recipe.RecipeDTO;

import java.time.LocalDateTime;
import java.util.Map;

public record DietDTO (
        String name,

        String description,

        Map<RecipeDTO, Double> recipes,

//        String imageUrl,

        String authorName,

        LocalDateTime created
){
}
