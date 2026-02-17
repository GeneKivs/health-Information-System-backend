package health.healthinformation.model;

import health.healthinformation.base.Auditable;
import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentID;

    @ManyToOne
    @JoinColumn(name = "clientID", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "healthProgramID")
    private HealthProgram healthProgram;

 
    public Long getEnrollment(){
        return enrollmentID;
    }

    public  void setEnrollmentID(Long enrollmentID){
        this.enrollmentID = enrollmentID;

    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public HealthProgram getHealthProgram(){
        return healthProgram;
    }

    public void setHealthProgram(HealthProgram healthProgram){
        this.healthProgram = healthProgram;
    }

}
