package bg.softuni.springexam.model.dto;

import java.util.List;

public record IngredientsDTO (
        List<RecipeIngredientDTO> ingredients
){

}
