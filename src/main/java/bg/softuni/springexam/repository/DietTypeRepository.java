package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.DietTypeEntity;
import bg.softuni.springexam.model.enums.DietType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DietTypeRepository extends JpaRepository<DietTypeEntity, UUID> {
    DietTypeEntity findByName(DietType type);
}
