package bg.softuni.springexam.init;

import bg.softuni.springexam.model.enums.DietType;
import bg.softuni.springexam.service.DietTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DietTypeInit implements CommandLineRunner {

    private final DietTypeService dietTypeService;

    public DietTypeInit(DietTypeService dietTypeService) {
        this.dietTypeService = dietTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (dietTypeService.isEmpty()) {
            for (DietType dietType : DietType.values()) {
                dietTypeService.addType(dietType);
            }
        }
    }
}
