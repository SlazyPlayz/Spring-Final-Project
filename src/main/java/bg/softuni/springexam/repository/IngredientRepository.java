package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, UUID> {

    Optional<IngredientEntity> findByName(String name);
}
