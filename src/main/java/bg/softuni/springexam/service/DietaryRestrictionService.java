package bg.softuni.springexam.service;

import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;
import bg.softuni.springexam.model.enums.DietaryRestriction;

import java.util.Set;

public interface DietaryRestrictionService {

    boolean restrictionExists(DietaryRestriction restriction);

    void addRestriction(DietaryRestriction restriction);

    Set<DietaryRestrictionEntity> getAllByNameIn(Set<DietaryRestriction> names);
}
