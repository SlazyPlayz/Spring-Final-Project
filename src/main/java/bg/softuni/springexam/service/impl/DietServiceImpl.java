package bg.softuni.springexam.service.impl;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.dto.diet.DietDTO;
import bg.softuni.springexam.model.entity.DietEntity;
import bg.softuni.springexam.repository.DietRepository;
import bg.softuni.springexam.service.DietService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DietServiceImpl implements DietService {

    private final DietRepository dietRepository;
    private final ModelMapper modelMapper;

    public DietServiceImpl(DietRepository dietRepository, ModelMapper modelMapper) {
        this.dietRepository = dietRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DietDTO> allDiets() {
        return dietRepository.findAll().stream().map(x -> modelMapper.map(x, DietDTO.class)).toList();
    }

    @Override
    public void addDiet(DietAddBindingModel dietAddBindingModel) {
        DietEntity diet = modelMapper.map(dietAddBindingModel, DietEntity.class);
        dietRepository.save(diet);
    }
}
