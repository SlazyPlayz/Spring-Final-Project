package bg.softuni.springexam.model.entity;

import bg.softuni.springexam.model.enums.DietType;
import jakarta.persistence.*;

@Entity
@Table(name = "diet_types")
public class DietTypeEntity extends BaseEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private DietType name;

    public DietType getName() {
        return name;
    }

    public DietTypeEntity setName(DietType name) {
        this.name = name;
        return this;
    }
}
