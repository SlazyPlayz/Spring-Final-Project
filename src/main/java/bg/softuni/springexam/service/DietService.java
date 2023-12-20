package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.dto.diet.DietDTO;
import bg.softuni.springexam.model.dto.recipe.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.recipe.RecipeDTO;
import bg.softuni.springexam.model.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface DietService {

    List<DietDTO> allDiets();

    void addDiet(DietAddBindingModel dietAddBindingModel);

    List<DietDTO> allUserDiets(UserEntity userEntity);

    boolean hasRecipe(UUID dietId, UUID recipeId);

    void addRecipeToDiet(UUID dietId, UUID recipeId);

    void removeRecipeFromDiet(UUID dietId, UUID recipeId);
}
