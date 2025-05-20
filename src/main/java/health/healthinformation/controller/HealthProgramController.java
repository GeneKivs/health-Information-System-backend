package health.healthinformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import health.healthinformation.model.HealthProgram;
import health.healthinformation.service.HealthProgramService;

@Controller
public class HealthProgramController {

    @Autowired
    private HealthProgramService healthProgramService;

    @GetMapping("/healthPrograms")
    public String showHealthProgramform(Model model){
        HealthProgram healthProgram = new HealthProgram();
        model.addAttribute("healthProgram", healthProgram);
        return "healthprogram";
    }

    @PostMapping("/saveHealthProgram")
    public String saveHealthProgram(@ModelAttribute("healthProgram") HealthProgram healthProgram, RedirectAttributes redirectAttributes ){
        System.out.println(healthProgram);
        healthProgramService.addHealthProgram(healthProgram);

        redirectAttributes.addFlashAttribute("successMessage", "Health program added successful!");
        return"redirect:/healthPrograms";
    }



}
