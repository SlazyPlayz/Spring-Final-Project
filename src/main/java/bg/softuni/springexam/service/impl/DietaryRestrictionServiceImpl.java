package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;
import bg.softuni.springexam.model.enums.DietaryRestriction;
import bg.softuni.springexam.repository.DietaryRestrictionRepository;
import bg.softuni.springexam.service.DietaryRestrictionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DietaryRestrictionServiceImpl implements DietaryRestrictionService {

    private final DietaryRestrictionRepository dietaryRestrictionRepository;

    public DietaryRestrictionServiceImpl(DietaryRestrictionRepository dietaryRestrictionRepository) {
        this.dietaryRestrictionRepository = dietaryRestrictionRepository;
    }

    @Override
    public boolean restrictionExists(DietaryRestriction restriction) {
        return dietaryRestrictionRepository.findByName(restriction).isPresent();
    }

    @Override
    public void addRestriction(DietaryRestriction restriction) {
        dietaryRestrictionRepository.save(new DietaryRestrictionEntity().setName(restriction));
    }

    @Override
    public Set<DietaryRestrictionEntity> getAllByNameIn(Set<DietaryRestriction> names) {
        return dietaryRestrictionRepository.getAllByNameIn(names).orElse(new HashSet<>());
    }
}
