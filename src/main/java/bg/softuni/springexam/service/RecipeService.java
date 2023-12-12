package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {

    List<RecipeDTO> allRecipes();

    void addRecipe(RecipeAddBindingModel recipeAddBindingModel);
}
