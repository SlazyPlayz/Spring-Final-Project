package bg.softuni.springexam.init;

import bg.softuni.springexam.model.enums.DietaryRestriction;
import bg.softuni.springexam.service.DietaryRestrictionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RestrictionInit implements CommandLineRunner {

    private final DietaryRestrictionService dietaryRestrictionService;

    public RestrictionInit(DietaryRestrictionService dietaryRestrictionService) {
        this.dietaryRestrictionService = dietaryRestrictionService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (DietaryRestriction restriction : DietaryRestriction.values()) {
            if (!dietaryRestrictionService.restrictionExists(restriction))
                dietaryRestrictionService.addRestriction(restriction);
        }
    }
}
