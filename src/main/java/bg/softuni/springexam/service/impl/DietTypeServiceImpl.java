package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.entity.DietTypeEntity;
import bg.softuni.springexam.model.enums.DietType;
import bg.softuni.springexam.repository.DietTypeRepository;
import bg.softuni.springexam.service.DietTypeService;
import org.springframework.stereotype.Service;

@Service
public class DietTypeServiceImpl implements DietTypeService {

    private final DietTypeRepository dietTypeRepository;

    public DietTypeServiceImpl(DietTypeRepository dietTypeRepository) {
        this.dietTypeRepository = dietTypeRepository;
    }


    @Override
    public void addType(DietType type) {
        dietTypeRepository.save(new DietTypeEntity().setName(type));
    }
}
