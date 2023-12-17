package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.ingredient.IngredientAddBindingModel;
import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;

import java.util.List;

public interface IngredientService {

    List<IngredientDTO> allIngredients();

    void addIngredient(IngredientAddBindingModel ingredientAddBindingModel);
}
