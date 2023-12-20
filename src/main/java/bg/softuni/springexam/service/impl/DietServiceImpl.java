package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.exception.DietNotFoundException;
import bg.softuni.springexam.exception.RecipeNotFoundException;
import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.dto.diet.DietDTO;
import bg.softuni.springexam.model.entity.DietEntity;
import bg.softuni.springexam.model.entity.RecipeEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.repository.DietRepository;
import bg.softuni.springexam.repository.RecipeRepository;
import bg.softuni.springexam.service.DietService;
import bg.softuni.springexam.service.DietTypeService;
import bg.softuni.springexam.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DietServiceImpl implements DietService {

    private final DietRepository dietRepository;
    private final RecipeRepository recipeRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final DietTypeService dietTypeService;

    public DietServiceImpl(DietRepository dietRepository, RecipeRepository recipeRepository, UserService userService, ModelMapper modelMapper, DietTypeService dietTypeService) {
        this.dietRepository = dietRepository;
        this.recipeRepository = recipeRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.dietTypeService = dietTypeService;
    }

    @Override
    public List<DietDTO> allDiets() {
        return dietRepository.findAll().stream().map(x -> modelMapper.map(x, DietDTO.class)).toList();
    }

    @Override
    public void addDiet(DietAddBindingModel dietAddBindingModel) {
        DietEntity diet = modelMapper.map(dietAddBindingModel, DietEntity.class);
        diet.setType(dietTypeService.findByName(dietAddBindingModel.getType()));
        diet.setAuthor(userService.loggedUser());
        diet.setCreated(LocalDateTime.now());
        dietRepository.save(diet);
    }

    @Override
    public List<DietDTO> allUserDiets(UserEntity userEntity) {
        return dietRepository.findAllByAuthor(userEntity).stream().map(x -> modelMapper.map(x, DietDTO.class)).toList();
    }

    @Override
    public boolean hasRecipe(UUID dietId, UUID recipeId) {
        DietEntity diet = dietRepository.findById(dietId).orElseThrow(() -> new DietNotFoundException(dietId));
        RecipeEntity recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        return diet.getRecipes().contains(recipe);
    }

    @Override
    public void addRecipeToDiet(UUID dietId, UUID recipeId) {
        DietEntity diet = dietRepository.findById(dietId).orElseThrow(() -> new DietNotFoundException(dietId));
        RecipeEntity recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        diet.getRecipes().add(recipe);
        dietRepository.save(diet);
    }

    @Override
    public void removeRecipeFromDiet(UUID dietId, UUID recipeId) {
        DietEntity diet = dietRepository.findById(dietId).orElseThrow(() -> new DietNotFoundException(dietId));
        RecipeEntity recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException(recipeId));
        diet.getRecipes().remove(recipe);
        dietRepository.save(diet);
    }
}
