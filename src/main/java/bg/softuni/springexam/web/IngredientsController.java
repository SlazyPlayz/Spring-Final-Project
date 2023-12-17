package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.ingredient.IngredientAddBindingModel;
import bg.softuni.springexam.model.dto.ingredient.IngredientDTO;
import bg.softuni.springexam.model.enums.DietaryRestriction;
import bg.softuni.springexam.service.DietaryRestrictionService;
import bg.softuni.springexam.service.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/ingredient/add-ingredient");

        modelAndView.addObject("ingredientAddBindingModel", IngredientAddBindingModel.empty());
        modelAndView.addObject("existingIngredients", ingredientService.allIngredients());
        modelAndView.addObject("dietaryRestrictions", DietaryRestriction.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(IngredientAddBindingModel ingredientAddBindingModel) {
        ingredientService.addIngredient(ingredientAddBindingModel);
        return new ModelAndView("redirect:/");
    }
}
