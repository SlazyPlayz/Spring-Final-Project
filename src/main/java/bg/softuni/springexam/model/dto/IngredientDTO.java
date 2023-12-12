package bg.softuni.springexam.model.dto;

import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;

import java.util.Set;

public record IngredientDTO (

        String name,

        Set<DietaryRestrictionEntity> dietaryRestrictions
){
}
