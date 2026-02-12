package health.healthinformation.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import health.healthinformation.model.Client;
import health.healthinformation.model.Enrollment;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.service.ClientService;
import health.healthinformation.service.EnrollmentService;
import health.healthinformation.service.HealthProgramService;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private HealthProgramService healthProgramService;

    @GetMapping("/enrollmentform")
    public String showEnrollmentForm(Model model) {
        Enrollment enrollment = new Enrollment();
        model.addAttribute("enrollment", enrollment);

        List<Client> clients = clientService.getAllclients();
        model.addAttribute("clients", clients);

        List<HealthProgram> healthPrograms = healthProgramService.getAllHealthPrograms();
        model.addAttribute("healthPrograms", healthPrograms);

        return "enrollmentform";
    }

    @PostMapping("/enroll")
    public String enroll(@ModelAttribute("enrollment") Enrollment enrollment,
            @RequestParam("clientID")int clientID,
            @RequestParam("healthProgramIDs")List<Integer> healthProgramIDs,
            RedirectAttributes redirectAttributes
            
    ){
            Client client = clientService.getClientbyClientID(clientID);

            for(int healthProgramID : healthProgramIDs){
                HealthProgram healthProgram = healthProgramService.getHealthProgramById(healthProgramID);

                Enrollment newEnrollment = new Enrollment();

                newEnrollment.setClient(client);
                newEnrollment.setHealthProgram(healthProgram);
                
                enrollmentService.addEnrollment(newEnrollment);
            }

        

        redirectAttributes.addFlashAttribute("successMessage", "Enrollment added successfully!");
        return "redirect:/enrollmentform";
    }

}
