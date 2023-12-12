package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientEntity, UUID> {

    Optional<RecipeIngredientEntity> findByIngredient_NameAndAmount(String ingredientName, int amount);
}
