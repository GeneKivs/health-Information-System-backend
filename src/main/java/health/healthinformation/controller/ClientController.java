package health.healthinformation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import health.healthinformation.model.Client;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.service.ClientService;
import health.healthinformation.service.EnrollmentService;

@Controller
public class ClientController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/clientform")
    public String showClientForm(Model model){
        Client client = new Client();
        model.addAttribute("client", client);
        return "clientform"; // Return the name of the view for the client form
    }

    @PostMapping("/registerClient")
    public String registerClient(@ModelAttribute("client") Client client,RedirectAttributes redirectAttributes){
        // Save the client using the service
        clientService.addclient(client);
        redirectAttributes.addFlashAttribute("successMessage", "cient registered successful!");
        return "redirect:/clientform"; // Redirect to the client form after registration
    }

    @GetMapping("/clientlist")
    public String showClientlistForm(Model model){
        List<Client> clients = clientService.getAllclients();
        model.addAttribute("clients", clients);
        return "clientlist"; // Return the name of the view for the client list
    }

    @GetMapping("/clientsearch")
    public String searchclients(@RequestParam("keyword") String keyword, Model model){
        List<Client> matchingClients = clientService.searchClientByName(keyword);
        model.addAttribute("clients", matchingClients);
        return "clientlist";
    }

    @GetMapping("/clientsprofile/{clientID}")
    public String showClientProfile(@PathVariable("clientID") int clientID,Model model){
        Client client = clientService.getClientbyClientID(clientID);
        model.addAttribute("client",client);

        List<HealthProgram> healthPrograms = enrollmentService.getHealthProgramsByClientID(clientID);
        model.addAttribute("healthPrograms", healthPrograms);
        return "clientprofile";
    }

}
