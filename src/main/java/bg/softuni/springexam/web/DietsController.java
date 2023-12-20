package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.enums.DietType;
import bg.softuni.springexam.service.DietService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/diets")
public class DietsController {

    private final DietService dietService;

    public DietsController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("/diet/add-diet");

        modelAndView.addObject("dietAddBindingModel", DietAddBindingModel.empty());
        modelAndView.addObject("dietTypes", DietType.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(DietAddBindingModel dietAddBindingModel) {
        dietService.addDiet(dietAddBindingModel);

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/{dietId}/add-recipe/{recipeId}")
    public ModelAndView addRecipe(@PathVariable UUID dietId, @PathVariable UUID recipeId) {

        if (dietService.hasRecipe(dietId, recipeId)) {
            dietService.addRecipeToDiet(dietId, recipeId);
            return new ModelAndView("redirect:/");
        }

        dietService.removeRecipeFromDiet(dietId, recipeId);
        return new ModelAndView("redirect:/");
    }
}
