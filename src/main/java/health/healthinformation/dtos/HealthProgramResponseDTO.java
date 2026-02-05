package health.healthinformation.dtos;

public class HealthProgramResponseDTO {

    private int healthProgramID;

    private String healthProgramName;

    private String description;

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
}
