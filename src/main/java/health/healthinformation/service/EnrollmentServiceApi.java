package health.healthinformation.service;

import java.util.List;

import health.healthinformation.dtos.EnrollmentRequestDTO;
import health.healthinformation.dtos.EnrollmentResponseDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;

public interface EnrollmentServiceApi {

  EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO requestDTO);
  
  EnrollmentResponseDTO updateEnrollment(Long enrollmentID, EnrollmentRequestDTO requestDTO);

  EnrollmentResponseDTO patchEnrollment(Long enrollmentID, EnrollmentRequestDTO requestDTO);

  EnrollmentResponseDTO getEnrollmentByID(Long enrollmentID);

  List<EnrollmentResponseDTO> getEnrollments();


  List<EnrollmentResponseDTO> enrollClientToPrograms(EnrollmentRequestDTO requestDTO);

  List<HealthProgramResponseDTO> getHealthProgramsByClientID(int clientID); 

}
