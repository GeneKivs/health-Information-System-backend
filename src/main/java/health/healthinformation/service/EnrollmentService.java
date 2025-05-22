package health.healthinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import health.healthinformation.model.Enrollment;
import health.healthinformation.model.HealthProgram;
import health.healthinformation.repository.EnrollmentRepository;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public void addEnrollment(Enrollment enrollment){
        enrollmentRepository.save(enrollment);
    }

    public Enrollment createEnrollment(Enrollment enrollment){
        return enrollmentRepository.save(enrollment);
    }

    public List<HealthProgram> getHealthProgramsByClientID(int clientID){
        return enrollmentRepository.findHealthProgramsByClientID(clientID);
    }

    public List<Enrollment > getAllEnrollments(){
        return enrollmentRepository.findAll() ;  
     }

     public void updateClient(Enrollment enrollment){
        enrollmentRepository.save(enrollment);
     }

}
