package bg.softuni.springexam.web;

import bg.softuni.springexam.model.dto.diet.DietAddBindingModel;
import bg.softuni.springexam.model.enums.DietType;
import bg.softuni.springexam.service.DietService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/diets")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
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
}
