package bg.softuni.springexam.model.dto;

import bg.softuni.springexam.model.entity.RecipeIngredientEntity;

import java.time.LocalDateTime;
import java.util.List;

public record RecipeDTO (

        String name,

        String description,

        List<RecipeIngredientEntity> ingredients,

        String imageUrl,

        String authorName,

        LocalDateTime created) {

}
