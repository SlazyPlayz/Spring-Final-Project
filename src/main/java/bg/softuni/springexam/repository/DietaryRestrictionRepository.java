package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.DietaryRestrictionEntity;
import bg.softuni.springexam.model.enums.DietaryRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface DietaryRestrictionRepository extends JpaRepository<DietaryRestrictionEntity, UUID> {

    Optional<DietaryRestrictionEntity> findByName(DietaryRestriction name);

    Optional<Set<DietaryRestrictionEntity>> getAllByNameIn(Set<DietaryRestriction> names);
}
