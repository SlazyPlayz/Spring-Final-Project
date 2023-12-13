package bg.softuni.springexam.model.dto;

import java.util.*;

public record RecipeAddBindingModel(
        String name,

        String description,
        String item,
        String amount,

        List<RecipeIngredientDTO> ingredients

//        String imageUrl
)
{


    public static RecipeAddBindingModel empty(List<IngredientDTO> ingredientNames) {
        RecipeIngredientDTO[] ingredients = new RecipeIngredientDTO[ingredientNames.size()];

        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i] = mapToRecipeIngredient(ingredientNames.get(i));
        }

        return new RecipeAddBindingModel("", "", "", "", Arrays.stream(ingredients).toList());
    }

    private static RecipeIngredientDTO mapToRecipeIngredient(IngredientDTO ingredientDTO) {
        return new RecipeIngredientDTO(ingredientDTO.name(), 0);
    }

}
