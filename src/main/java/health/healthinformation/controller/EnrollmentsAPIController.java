package health.healthinformation.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import health.healthinformation.dtos.EnrollmentRequestDTO;
import health.healthinformation.dtos.EnrollmentResponseDTO;
import health.healthinformation.model.Client;
import health.healthinformation.model.Enrollment;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.service.ClientService;
import health.healthinformation.service.EnrollmentService;
import health.healthinformation.service.EnrollmentServiceApi;
import health.healthinformation.service.HealthProgramService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentsAPIController {

    private final EnrollmentServiceApi enrollmentServiceApi;

    @Autowired
    private  EnrollmentService enrollmentService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private HealthProgramService healthProgramService;

    EnrollmentsAPIController(EnrollmentServiceApi enrollmentService) {
        this.enrollmentServiceApi = enrollmentService;
    }

    //Enroll a client into multiple programs
    @PostMapping("/client/{clientID}")
    public ResponseEntity<String> enrollClieEntity(@PathVariable int clientID,
                                                   @RequestBody List<Integer> healthProgramIDs  ){
        Client client = clientService.getClientbyClientID(clientID);
        if(client == null) return ResponseEntity.notFound().build();

        for(Integer healthProgramID : healthProgramIDs){
            HealthProgram healthProgram = healthProgramService.getHealthProgramById(healthProgramID);
            if(healthProgram != null){
                Enrollment enrollment = new Enrollment();

                enrollment.setClient(client);
                enrollment.setHealthProgram(healthProgram);
                enrollment.setEnrollmentDate(LocalDate.now().toString());
                enrollmentService.createEnrollment(enrollment);
            }
        }
        return ResponseEntity.ok("Client enrolled Successfully.");

     }

     //Get all healthPrograms a client is enrolled in
     @GetMapping("/client/{clientID}/healthPrograms")
     public  List<HealthProgram> getClientEnrolledPrograms(@PathVariable int clientID){
        return enrollmentService.getHealthProgramsByClientID(clientID);
     }

     @PostMapping("/bulk")
     public ResponseEntity<List<EnrollmentResponseDTO>> enrollClient(@RequestBody EnrollmentRequestDTO requestDTO){
        return ResponseEntity.ok(enrollmentServiceApi.enrollClientToPrograms(requestDTO));
     }
}
