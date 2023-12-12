package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.IngredientDTO;
import bg.softuni.springexam.model.entity.IngredientEntity;
import bg.softuni.springexam.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IngredientDTO>> getAll() {
        return ResponseEntity.ok(ingredientService.allIngredients());
//        TODO: Finish add ingredients
    }
}
