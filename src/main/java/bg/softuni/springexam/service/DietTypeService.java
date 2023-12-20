package bg.softuni.springexam.service;

import bg.softuni.springexam.model.entity.DietTypeEntity;
import bg.softuni.springexam.model.enums.DietType;

public interface DietTypeService {

    void addType(DietType type);

    boolean isEmpty();

    DietTypeEntity findByName(DietType type);
}
