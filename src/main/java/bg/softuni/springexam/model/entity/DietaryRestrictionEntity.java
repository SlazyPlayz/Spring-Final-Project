package bg.softuni.springexam.model.entity;

import bg.softuni.springexam.model.enums.DietaryRestriction;
import jakarta.persistence.*;

@Entity
@Table(name = "dietary_restriction")
public class DietaryRestrictionEntity extends BaseEntity {

    @Column(name = "restriction")
    @Enumerated(EnumType.STRING)
    private DietaryRestriction name;

    public DietaryRestriction getName() {
        return name;
    }

    public DietaryRestrictionEntity setName(DietaryRestriction name) {
        this.name = name;
        return this;
    }
}
