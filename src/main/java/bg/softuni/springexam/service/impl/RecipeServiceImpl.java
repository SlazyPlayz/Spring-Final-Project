package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.IngredientNotFoundException;
import bg.softuni.springexam.exception.RecipeNotFoundException;
import bg.softuni.springexam.model.dto.IngredientDTO;
import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.model.entity.RecipeEntity;
import bg.softuni.springexam.repository.IngredientRepository;
import bg.softuni.springexam.repository.RecipeIngredientRepository;
import bg.softuni.springexam.repository.RecipeRepository;
import bg.softuni.springexam.service.RecipeService;

import bg.softuni.springexam.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserService userService;
    private final IngredientRepository ingredientRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, UserService userService,
                             IngredientRepository ingredientRepository,
                             RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<RecipeDTO> allRecipes() {
        List<RecipeEntity> recipes = recipeRepository.findAll();

        return recipes.stream().map(this::mapToDTO).toList();
    }

    @Override
    public void addRecipe(RecipeAddBindingModel recipeAddBindingModel) {

        Map<IngredientEntity, Integer> ingredients = new HashMap<>();
        recipeAddBindingModel.ingredients().forEach(ingredient -> {
            ingredients.put(
                    ingredientRepository.findByName(ingredient.name())
                            .orElseThrow(() -> new IngredientNotFoundException(ingredient.name())),
                    ingredient.amount());
        });

        RecipeEntity recipe = new RecipeEntity()
                .setName(recipeAddBindingModel.name())
                .setDescription(recipeAddBindingModel.description())
                .setIngredients(ingredients)
                .setImageUrl(recipeAddBindingModel.imageUrl())
                .setAuthor(userService.loggedUser())
                .setCreated(LocalDateTime.now());

        recipeRepository.save(recipe);
    }

    @Override
    public RecipeDTO findById(UUID id) {
        return recipeRepository.findById(id).map(this::mapToDTO).orElseThrow(() -> new RecipeNotFoundException(id));
    }

    private RecipeDTO mapToDTO(RecipeEntity recipe) {

        Map<IngredientDTO, Integer> ingredients = new HashMap<>();
        recipe.getIngredients().forEach((ingredient, amount) -> {
            ingredients.put(mapIngredientEntityToDTO(ingredient), amount);
        });

        return new RecipeDTO(recipe.getName(), recipe.getDescription(), ingredients, recipe.getImageUrl(), recipe.getAuthor().getFirstName() + " " + recipe.getAuthor().getLastName(), recipe.getCreated());
    }

    private IngredientEntity mapIngredientDTOToEntity(IngredientDTO ingredient) {
        return ingredientRepository.findByName(ingredient.name()).orElseThrow(() -> new IngredientNotFoundException(ingredient.name()));
    }

    private IngredientDTO mapIngredientEntityToDTO(IngredientEntity ingredient) {
        return new IngredientDTO(ingredient.getName(), ingredient.getRestrictions());
    }
}
