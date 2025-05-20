package health.healthinformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "healthprograms")
public class HealthProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int healthProgramID;
    @Column(name = "healthProgramName")
    private String healthProgramName;
    private String description;
    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public int getHealthProgramID(){
        return healthProgramID;
    }

    public void setHealthProgramID(int healthProgramID){
        this.healthProgramID = healthProgramID;
    }

    public String getHealthProgramName(){
        return healthProgramName;
    }

    public void setHealthProgramName(String hpName){
        this.healthProgramName = hpName;
    }

}
