package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.dto.recipe.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.recipe.RecipeDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeService {

    List<RecipeDTO> allRecipes();

    void addRecipe(RecipeAddBindingModel recipeAddBindingModel);

    RecipeDTO findById(UUID id);

    IngredientDTO mapIngredientEntityToDTO(IngredientEntity ingredient);
}
