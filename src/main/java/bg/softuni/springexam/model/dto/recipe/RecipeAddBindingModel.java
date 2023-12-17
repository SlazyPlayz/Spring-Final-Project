package bg.softuni.springexam.model.dto.recipe;

import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;

import java.util.*;

public class RecipeAddBindingModel {

    private String name;
    private String description;
    private RecipeIngredientDTO[] ingredients;

//        String imageUrl

    public RecipeAddBindingModel(
            String name,
            String description,
            RecipeIngredientDTO[] ingredients
    ) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }


    public static RecipeAddBindingModel empty(List<IngredientDTO> ingredientNames) {
        RecipeIngredientDTO[] ingredients = new RecipeIngredientDTO[ingredientNames.size()];

        for (int i = 0; i < ingredients.length; i++) {
            ingredients[i] = mapToRecipeIngredient(ingredientNames.get(i));
        }

        return new RecipeAddBindingModel("", "",  ingredients);
    }

    private static RecipeIngredientDTO mapToRecipeIngredient(IngredientDTO ingredientDTO) {
        return new RecipeIngredientDTO(ingredientDTO.getName(), 0.0);
    }

    public String getName() {
        return name;
    }

    public RecipeAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RecipeAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public RecipeIngredientDTO[] getIngredients() {
        return ingredients;
    }

    public RecipeAddBindingModel setIngredients(RecipeIngredientDTO[] ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
