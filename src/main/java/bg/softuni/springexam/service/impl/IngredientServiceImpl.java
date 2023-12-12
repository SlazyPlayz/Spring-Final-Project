package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.dto.IngredientDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.repository.IngredientRepository;
import bg.softuni.springexam.service.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDTO> allIngredients() {
        return ingredientRepository.findAll().stream().map(this::map).toList();
    }

    @Override
    public void addIngredient(IngredientEntity ingredient) {
        ingredientRepository.save(ingredient);
    }

    private IngredientDTO map(IngredientEntity ingredient) {
        return new IngredientDTO(ingredient.getName(), ingredient.getRestrictions());
    }
}
