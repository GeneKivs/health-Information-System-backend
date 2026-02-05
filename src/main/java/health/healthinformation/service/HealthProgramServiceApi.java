package health.healthinformation.service;

import java.util.List;

import health.healthinformation.dtos.HealthProgramRequestDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;

public interface HealthProgramServiceApi {

    HealthProgramResponseDTO createProgram(HealthProgramRequestDTO requestDTO);

    HealthProgramResponseDTO updateProgram(int programID,HealthProgramRequestDTO requestDTO);

    HealthProgramResponseDTO patchProgram(int programID, HealthProgramRequestDTO requestDTO);

    HealthProgramResponseDTO getProgramByID(int programID);

    List<HealthProgramResponseDTO> getAllPrograms();

}
