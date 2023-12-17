package bg.softuni.springexam.config;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.dto.ingredient.IngredientAddBindingModel;
import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.dto.user.UserDTO;
import bg.softuni.springexam.model.entity.DietEntity;
import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import bg.softuni.springexam.model.enums.DietaryRestriction;
import bg.softuni.springexam.service.DietaryRestrictionService;
import bg.softuni.springexam.service.UserService;
import org.apache.catalina.User;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    private final DietaryRestrictionService dietaryRestrictionService;
    private final UserService userService;

    public AppConfig(DietaryRestrictionService dietaryRestrictionService, UserService userService) {
        this.dietaryRestrictionService = dietaryRestrictionService;
        this.userService = userService;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        final Provider<UserEntity> loggedUserProvider = request -> userService.loggedUser();

        Converter<UserEntity, UserDTO> loggedUserConverter =
                x -> (x.getSource() == null) ? null : new UserDTO()
                        .setUsername(x.getSource().getUsername())
                        .setEmail(x.getSource().getEmail())
                        .setFullName(x.getSource().getFullName())
                        .setImageUrl(x.getSource().getImageUrl());

        Converter<Set<DietaryRestriction>, Set<DietaryRestrictionEntity>> toEntitySet =
                x -> (x.getSource() == null) ? null : dietaryRestrictionService.getAllByNameIn(x.getSource());

        Converter<Map<IngredientEntity, Double>, Map<IngredientDTO, Double>> toDTOMap =
                x -> (x.getSource() == null) ? null : x.getSource().entrySet().stream()
                        .map(entry -> new AbstractMap.SimpleEntry<>(
                                modelMapper.map(entry.getKey(), IngredientDTO.class),
                                entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Converter<Map<IngredientDTO, Double>, Map<IngredientEntity, Double>> toEntityMap =
                x -> (x.getSource() == null) ? null : x.getSource().entrySet().stream()
                        .map(entry -> new AbstractMap.SimpleEntry<>(
                                modelMapper.map(entry.getKey(), IngredientEntity.class),
                                entry.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        modelMapper
                .createTypeMap(UserEntity.class, UserDTO.class)
                .addMappings(mapping -> mapping
                        .map(UserEntity::getUsername, UserDTO::setUsername))
                .addMappings(mapping -> mapping
                        .map(UserEntity::getFullName, UserDTO::setFullName))
                .addMappings(mapping -> mapping
                        .map(UserEntity::getEmail, UserDTO::setEmail))
                .addMappings(mapping -> mapping
                        .map(UserEntity::getImageUrl, UserDTO::setImageUrl));

        modelMapper
                .createTypeMap(UserDTO.class, UserEntity.class)
                .addMappings(mapping -> mapping
                        .map(UserDTO::getUsername, UserEntity::setUsername))
                .addMappings(mapping -> mapping
                        .map(UserDTO::getFullName, UserEntity::setFullName))
                .addMappings(mapping -> mapping
                        .map(UserDTO::getEmail, UserEntity::setEmail))
                .addMappings(mapping -> mapping
                        .map(UserDTO::getImageUrl, UserEntity::setImageUrl));

        modelMapper
                .createTypeMap(IngredientEntity.class, IngredientDTO.class)
                .addMappings(mapping -> mapping
                        .using(toDTOMap)
                        .map(IngredientEntity::getName, IngredientDTO::setName))
                .addMappings(mapping -> mapping
                        .using(toDTOMap)
                        .map(IngredientEntity::getRestrictions, IngredientDTO::setDietaryRestrictions));

        modelMapper
                .createTypeMap(IngredientDTO.class, IngredientEntity.class)
                .addMappings(mapping -> mapping
                        .using(toEntityMap)
                        .map(IngredientDTO::getName, IngredientEntity::setName))
                .addMappings(mapping -> mapping
                        .using(toEntityMap)
                        .map(IngredientDTO::getDietaryRestrictions, IngredientEntity::setRestrictions))
                .addMappings(mapping -> mapping
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .using(loggedUserConverter)
                        .map(userService.loggedUser(), IngredientEntity::setAuthor));
//        TODO: Add mapping for author.

        modelMapper
                .createTypeMap(DietAddBindingModel.class, DietEntity.class)
                .addMappings(mapping -> mapping
                        .map(DietAddBindingModel::getName, DietEntity::setName))
                .addMappings(mapping -> mapping
                        .map(DietAddBindingModel::getDescription, DietEntity::setDescription))
                .addMappings(mapping -> mapping
                        .map(DietAddBindingModel::getType, DietEntity::setType))
                .addMappings(mapping -> mapping
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .using(loggedUserConverter)
                        .map(DietAddBindingModel::getAuthor, DietEntity::setAuthor));

        modelMapper
                .createTypeMap(IngredientAddBindingModel.class, IngredientEntity.class)
                .addMappings(mapping -> mapping
                        .map(IngredientAddBindingModel::getName, IngredientEntity::setName))
                .addMappings(mapping -> mapping
                        .using(toEntitySet)
                        .map(IngredientAddBindingModel::getRestrictions, IngredientEntity::setRestrictions))
                .addMappings(mapping -> mapping
                        .when(Conditions.isNull())
                        .with(loggedUserProvider)
                        .using(loggedUserConverter)
                        .map(IngredientAddBindingModel::getAuthor, IngredientEntity::setAuthor));

        return modelMapper;
    }

}
