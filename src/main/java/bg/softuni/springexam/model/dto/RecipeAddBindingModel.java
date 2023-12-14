package bg.softuni.springexam.model.dto;

import java.util.*;

public record RecipeAddBindingModel(
        String name,

        String description,
        String item,
        String amount,

        String ingredients

//        String imageUrl
)
{


    public static RecipeAddBindingModel empty(List<IngredientDTO> ingredientNames) {
//        RecipeIngredientDTO[] ingredients = new RecipeIngredientDTO[ingredientNames.size()];
//
//        for (int i = 0; i < ingredients.length; i++) {
//            ingredients[i] = mapToRecipeIngredient(ingredientNames.get(i));
//        }

        return new RecipeAddBindingModel("", "", "", "", "");
    }

    private static RecipeIngredientDTO mapToRecipeIngredient(IngredientDTO ingredientDTO) {
        return new RecipeIngredientDTO(ingredientDTO.name(), 0);
    }

}
