package health.healthinformation.controller;


import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import health.healthinformation.dtos.EnrollmentRequestDTO;
import health.healthinformation.dtos.EnrollmentResponseDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;


import health.healthinformation.service.EnrollmentServiceApi;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentsAPIController {

    private final EnrollmentServiceApi enrollmentServiceApi;


    

    EnrollmentsAPIController(EnrollmentServiceApi enrollmentService) {
        this.enrollmentServiceApi = enrollmentService;
    }

   

     //Get all healthPrograms a client is enrolled in
     @GetMapping("/client/{clientID}/healthPrograms")
     public  ResponseEntity<List<HealthProgramResponseDTO>> getClientEnrolledPrograms(@PathVariable int clientID){
         List<HealthProgramResponseDTO> reponse = enrollmentServiceApi.getHealthProgramsByClientID(clientID);
        return ResponseEntity.ok(reponse);
     }

     @PostMapping("/bulk")
     public ResponseEntity<List<EnrollmentResponseDTO>> enrollClient(@RequestBody EnrollmentRequestDTO requestDTO){
        return ResponseEntity.ok(enrollmentServiceApi.enrollClientToPrograms(requestDTO));
     }
}
