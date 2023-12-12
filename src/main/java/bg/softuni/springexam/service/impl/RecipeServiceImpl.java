package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.IngredientNotFoundException;
import bg.softuni.springexam.model.dto.IngredientDTO;
import bg.softuni.springexam.model.dto.RecipeAddBindingModel;
import bg.softuni.springexam.model.dto.RecipeDTO;
import bg.softuni.springexam.model.dto.RecipeIngredientDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.model.entity.RecipeEntity;
import bg.softuni.springexam.model.entity.RecipeIngredientEntity;
import bg.softuni.springexam.repository.IngredientRepository;
import bg.softuni.springexam.repository.RecipeIngredientRepository;
import bg.softuni.springexam.repository.RecipeRepository;
import bg.softuni.springexam.service.RecipeService;

import bg.softuni.springexam.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserService userService;
    private final IngredientRepository ingredientRepository;
    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository, UserService userService,
                             IngredientRepository ingredientRepository,
                             RecipeIngredientRepository recipeIngredientRepository) {
        this.recipeRepository = recipeRepository;
        this.userService = userService;
        this.ingredientRepository = ingredientRepository;
        this.recipeIngredientRepository = recipeIngredientRepository;
    }

    @Override
    public List<RecipeDTO> allRecipes() {
        List<RecipeEntity> recipes = recipeRepository.findAll();

        return recipes.stream().map(this::mapToDTO).toList();
    }

    @Override
    public void addRecipe(RecipeAddBindingModel recipeAddBindingModel) {
        RecipeEntity recipe = new RecipeEntity()
                .setName(recipeAddBindingModel.name())
                .setDescription(recipeAddBindingModel.description())
                .setIngredients(recipeAddBindingModel.ingredients().stream().map(this::mapIngredientDTOToEntity).toList())
                .setImageUrl(recipeAddBindingModel.imageUrl())
                .setAuthor(userService.loggedUser())
                .setCreated(LocalDateTime.now());

        recipeRepository.save(recipe);
    }

    private RecipeDTO mapToDTO(RecipeEntity recipe) {
        return new RecipeDTO(recipe.getName(), recipe.getDescription(), recipe.getIngredients(), recipe.getImageUrl(), recipe.getAuthor().getFirstName() + " " + recipe.getAuthor().getLastName(), recipe.getCreated());
    }

    private RecipeIngredientEntity mapIngredientDTOToEntity(RecipeIngredientDTO ingredientDTO) {
        return recipeIngredientRepository.findByIngredient_NameAndAmount(ingredientDTO.name(), ingredientDTO.amount()).orElseThrow(() -> new IngredientNotFoundException(ingredientDTO.name()));
    }
}
