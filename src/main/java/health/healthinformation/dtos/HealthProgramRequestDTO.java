package health.healthinformation.dtos;

public class HealthProgramRequestDTO {

    private String healthProgramName;
    private String description;

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
