package health.healthinformation.mapper;

import health.healthinformation.dtos.EnrollmentResponseDTO;
import health.healthinformation.model.Enrollment;

public class EnrollmentMapper {

    public EnrollmentMapper (){}

    public static EnrollmentResponseDTO toResponseDTO(Enrollment enrollment){

        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();

        dto.setEnrollmentID(enrollment.getEnrollment());

        if (enrollment.getClient() != null) {
            dto.setClientID(enrollment.getClient().getClientID());
            String fullName = enrollment.getClient().getFirstName() + " " + enrollment.getClient().getLastName();
            dto.setClientName(fullName);
        }

        if (enrollment.getHealthProgram() != null) {
            dto.setProgramID(enrollment.getHealthProgram().getHealthProgramID());
            dto.setProgramName(enrollment.getHealthProgram().getHealthProgramName());
        }

        return dto;


    }

}
