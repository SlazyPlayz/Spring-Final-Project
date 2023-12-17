package bg.softuni.springexam.repository;

import bg.softuni.springexam.model.entity.RoleEntity;
import bg.softuni.springexam.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

    Optional<RoleEntity> findByRole(Role role);
}
