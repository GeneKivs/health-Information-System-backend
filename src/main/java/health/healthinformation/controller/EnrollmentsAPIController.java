package health.healthinformation.controller;


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


import health.healthinformation.model.HealthProgram;

import health.healthinformation.service.EnrollmentService;
import health.healthinformation.service.EnrollmentServiceApi;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentsAPIController {

    private final EnrollmentServiceApi enrollmentServiceApi;

    @Autowired
    private  EnrollmentService enrollmentService;

    

    EnrollmentsAPIController(EnrollmentServiceApi enrollmentService) {
        this.enrollmentServiceApi = enrollmentService;
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
