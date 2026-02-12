package health.healthinformation.mapper;

import health.healthinformation.dtos.HealthProgramRequestDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;
import health.healthinformation.model.HealthProgram;

public class HealthProgramMapper {

    private HealthProgramMapper(){}

    public static HealthProgram toEntity(HealthProgramRequestDTO dto){
        if (dto == null) {
            return null;
        }

        HealthProgram program = new HealthProgram();
        program.setHealthProgramName(dto.getHealthProgramName());
        program.setDescription(dto.getDescription());

        return program;
    } 

    public static HealthProgramResponseDTO toResponse(HealthProgram program){
        if (program == null) {
            return null;
        }

        HealthProgramResponseDTO dto = new HealthProgramResponseDTO();
        dto.setHealthProgramID(program.getHealthProgramID());
        dto.setHealthProgramName(program.getHealthProgramName());
        dto.setDescription(program.getDescription());
        dto.setCreatedAT(program.getCreatedAt());
        dto.setUpdatedAT(program.getUpdatedAT());

        return dto;
    }

}
