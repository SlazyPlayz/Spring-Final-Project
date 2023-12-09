package bg.softuni.springexam.model.entity;

import bg.softuni.springexam.model.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public RoleEntity setRole(Role role) {
        this.role = role;
        return this;
    }
}
