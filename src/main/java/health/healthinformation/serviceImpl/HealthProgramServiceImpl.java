package health.healthinformation.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import health.healthinformation.dtos.HealthProgramRequestDTO;
import health.healthinformation.dtos.HealthProgramResponseDTO;
import health.healthinformation.mapper.HealthProgramMapper;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.repository.HealthProgramRepository;
import health.healthinformation.service.HealthProgramServiceApi;

@Service
public class HealthProgramServiceImpl implements HealthProgramServiceApi {

    private final HealthProgramRepository programRepository;

    public HealthProgramServiceImpl(HealthProgramRepository programRepository){
        this.programRepository = programRepository;
    }

    @Override
    public HealthProgramResponseDTO createProgram(HealthProgramRequestDTO requestDTO){
        HealthProgram program = HealthProgramMapper.toEntity(requestDTO);
        HealthProgram savedHealthProgram = programRepository.save(program);

        return  HealthProgramMapper.toResponse(savedHealthProgram);

    }

    @Override
    public HealthProgramResponseDTO updateProgram(int programID,HealthProgramRequestDTO requestDTO){
        HealthProgram existingProgram = programRepository.findById(programID).orElseThrow();

        existingProgram.setHealthProgramName(requestDTO.getHealthProgramName());
        existingProgram.setDescription(requestDTO.getDescription());

        HealthProgram updatedProgram = programRepository.save(existingProgram);
        return HealthProgramMapper.toResponse(updatedProgram);
    } 


    @Override
    public HealthProgramResponseDTO patchProgram(int programID,HealthProgramRequestDTO requestDTO){
        HealthProgram existingProgram = programRepository.findById(programID).orElseThrow();

        if (requestDTO.getHealthProgramName() != null) {
            existingProgram.setHealthProgramName(requestDTO.getHealthProgramName());
        }

        if (requestDTO.getDescription() != null) {
            existingProgram.setDescription(requestDTO.getDescription());
        }

        HealthProgram patchedProgram = programRepository.save(existingProgram);

        return HealthProgramMapper.toResponse(patchedProgram);
    }


    @Override
    public HealthProgramResponseDTO getProgramByID(int programID){
        return programRepository.findById(programID)
                .map(HealthProgramMapper::toResponse)
                .orElseThrow();

    }

    @Override
    public List<HealthProgramResponseDTO> getAllPrograms(){
        return programRepository.findAll()
                .stream()
                .map(HealthProgramMapper::toResponse)
                .collect(Collectors.toList());
    }

}
