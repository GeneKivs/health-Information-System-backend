package health.healthinformation.dtos;

import java.time.LocalDate;

public class HealthProgramResponseDTO {

    private int healthProgramID;

    private String healthProgramName;

    private String description;

    private LocalDate createdAT;

    private LocalDate updatedAT; 

    public int getHealthProgramID(){
        return healthProgramID;
    }

    public void setHealthProgramID(int id){
        this.healthProgramID = id;
    }

    public String getHealthProgramName(){
        return healthProgramName;
    }

    public void setHealthProgramName(String name){
        this.healthProgramName = name;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDate getCreatedAT(){
        return createdAT;
    }

    public void setCreatedAT(LocalDate date){
        this.createdAT = date;
    }

    public LocalDate getUpdatedAT(){
        return updatedAT;
    }

    public void setUpdatedAT(LocalDate date){
        this.updatedAT = date;
    }
}
