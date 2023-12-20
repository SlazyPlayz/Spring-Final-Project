package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.DietEntity;
import bg.softuni.springexam.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Set;
import java.util.UUID;

@Repository
public interface DietRepository extends JpaRepository<DietEntity, UUID> {
    Set<DietEntity> findAllByAuthor(UserEntity userEntity);
}
