package bg.softuni.springexam.model.entity;

import bg.softuni.springexam.model.enums.DietaryRestriction;
import jakarta.persistence.*;

@Entity
@Table(name = "dietary_restriction")
public class DietaryRestrictionsEntity extends BaseEntity {

    @Column(name = "restriction")
    @Enumerated(EnumType.STRING)
    private DietaryRestriction restriction;

    public DietaryRestriction getRestriction() {
        return restriction;
    }

    public DietaryRestrictionsEntity setRestriction(DietaryRestriction restriction) {
        this.restriction = restriction;
        return this;
    }
}
