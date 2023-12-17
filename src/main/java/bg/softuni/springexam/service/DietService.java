package bg.softuni.springexam.service;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.dto.diet.DietDTO;
import bg.softuni.springexam.model.dto.recipe.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.recipe.RecipeDTO;

import java.util.List;
import java.util.UUID;

public interface DietService {

    List<DietDTO> allDiets();

    void addDiet(DietAddBindingModel dietAddBindingModel);
}
