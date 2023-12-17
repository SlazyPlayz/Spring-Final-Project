package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.dto.ingredient.IngredientAddBindingModel;
import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.repository.IngredientRepository;
import bg.softuni.springexam.service.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, ModelMapper modelMapper) {
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<IngredientDTO> allIngredients() {
        return ingredientRepository.findAll().stream().map(this::mapEntityToDTO).toList();
    }

    @Override
    public void addIngredient(IngredientAddBindingModel ingredientAddBindingModel) {
        IngredientEntity ingredient = modelMapper.map(ingredientAddBindingModel, IngredientEntity.class);
        ingredientRepository.save(ingredient);
    }

    private IngredientDTO mapEntityToDTO(IngredientEntity ingredient) {
        return new IngredientDTO().setName(ingredient.getName()).setDietaryRestrictions(ingredient.getRestrictions());
    }
}
