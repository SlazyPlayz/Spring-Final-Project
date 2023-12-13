package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;
import bg.softuni.springexam.model.entity.RecipeEntity;

import java.util.List;
import java.util.UUID;

public interface RecipeService {

    List<RecipeDTO> allRecipes();

    void addRecipe(RecipeAddBindingModel recipeAddBindingModel);

    RecipeDTO findById(UUID id);
}
