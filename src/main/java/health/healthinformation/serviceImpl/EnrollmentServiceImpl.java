package health.healthinformation.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import health.healthinformation.dtos.EnrollmentRequestDTO;
import health.healthinformation.dtos.EnrollmentResponseDTO;
import health.healthinformation.mapper.EnrollmentMapper;
import health.healthinformation.model.Client;
import health.healthinformation.model.Enrollment;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.repository.ClientRepository;
import health.healthinformation.repository.EnrollmentRepository;
import health.healthinformation.repository.HealthProgramRepository;
import health.healthinformation.service.EnrollmentServiceApi;

@Service
public class EnrollmentServiceImpl implements EnrollmentServiceApi {

    private final EnrollmentRepository enrollmentRepository;
    private final ClientRepository clientRepository;
    private final HealthProgramRepository programRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,ClientRepository clientRepository, HealthProgramRepository programRepository){
        this.enrollmentRepository = enrollmentRepository;
        this.clientRepository = clientRepository;
        this.programRepository = programRepository;
    }

    @Override
    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO requestDTO){
        Client client = clientRepository.findById(requestDTO.getClientID()).orElseThrow();
        HealthProgram program = programRepository.findById(requestDTO.getHealthProgramID()).orElseThrow();

        Enrollment enrollment = new Enrollment();
        enrollment.setClient(client);
        enrollment.setHealthProgram(program);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.toResponseDTO(savedEnrollment);
    }

    @Override
    public EnrollmentResponseDTO updateEnrollment(Long enrollmentID,EnrollmentRequestDTO requestDTO){
        Enrollment existingEnrollment = enrollmentRepository.findById(null).orElseThrow();
        Client client = clientRepository.findById(requestDTO.getClientID()).orElseThrow();
        HealthProgram program = programRepository.findById(requestDTO.getHealthProgramID()).orElseThrow();

        existingEnrollment.setClient(client);
        existingEnrollment.setHealthProgram(program);

        return EnrollmentMapper.toResponseDTO(enrollmentRepository.save(existingEnrollment));
    }

    @Override
    public EnrollmentResponseDTO patchEnrollment(Long enrollmantID,EnrollmentRequestDTO requestDTO){
        Enrollment existingEnrollment = enrollmentRepository.findById(enrollmantID).orElseThrow();
        
        if (requestDTO.getClientID() != null) {
            Client client = clientRepository.findById(requestDTO.getClientID()).orElseThrow();
            existingEnrollment.setClient(client);
        }

        if (requestDTO.getHealthProgramID() != null) {
            HealthProgram program = programRepository.findById(requestDTO.getHealthProgramID()).orElseThrow();
            existingEnrollment.setHealthProgram(program);
        }

        return EnrollmentMapper.toResponseDTO(enrollmentRepository.save(existingEnrollment));
    }

    @Override
    public EnrollmentResponseDTO getEnrollmentByID(Long enrollmentID){
        return enrollmentRepository.findById(enrollmentID)
                .map(EnrollmentMapper::toResponseDTO)
                .orElseThrow();
    }
    

    @Override
    public List<EnrollmentResponseDTO> getEnrollments(){
        return enrollmentRepository.findAll()
                .stream()
                .map(EnrollmentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentResponseDTO> enrollClientToPrograms(EnrollmentRequestDTO requestDTO){

        Client client = clientRepository.findById(requestDTO.getClientID()).orElseThrow();

        return requestDTO.getHealthProgramsIDs()
                .stream()
                .map(programID -> {
                    HealthProgram program = programRepository.findById(programID).orElseThrow();

                    Enrollment enrollment = new Enrollment();
                    enrollment.setClient(client);
                    enrollment.setHealthProgram(program);
                   
                    
                    Enrollment saved = enrollmentRepository.save(enrollment);
                    return EnrollmentMapper.toResponseDTO(saved);
                })
                .collect(Collectors.toList());
    }

}
