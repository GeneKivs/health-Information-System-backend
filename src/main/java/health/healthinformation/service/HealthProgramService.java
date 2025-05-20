package health.healthinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import health.healthinformation.model.HealthProgram;
import health.healthinformation.repository.HealthProgramRepository;

@Service
public class HealthProgramService {

    @Autowired
    private HealthProgramRepository healthProgramRepository;

    public void addHealthProgram(HealthProgram healthProgram){
        healthProgramRepository.save(healthProgram);
    }

    public List<HealthProgram> getAllHealthPrograms(){
        return healthProgramRepository.findAll();
    }

    public HealthProgram getHealthProgramById(int healthProgramID){
        return healthProgramRepository.findByHealthProgramID(healthProgramID);
    }

    public void updtaeHealthProgram(HealthProgram healthProgram){
        healthProgramRepository.save(healthProgram);
    }

    public void deleteHealthProgram(int healthProgramID){
        healthProgramRepository.deleteById(healthProgramID);
    }

}
