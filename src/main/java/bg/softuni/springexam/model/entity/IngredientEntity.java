package bg.softuni.springexam.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ingredients")
public class IngredientEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "dietary_restrictions")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ingredients_restrictions",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "restriction_id")
    )
    private Set<DietaryRestrictionEntity> restrictions;

    public String getName() {
        return name;
    }

    public IngredientEntity setName(String name) {
        this.setId(UUID.randomUUID());
        this.name = name;
        return this;
    }

    public Set<DietaryRestrictionEntity> getRestrictions() {
        return restrictions;
    }

    public IngredientEntity setRestrictions(Set<DietaryRestrictionEntity> restrictions) {
        this.restrictions = restrictions;
        return this;
    }
}
