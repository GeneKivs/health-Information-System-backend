package health.healthinformation.dtos;

import java.util.List;

public class EnrollmentRequestDTO {

    private Integer clientID;

    private Integer healthProgramID;

    private List<Integer> healthProgramIDs;

    public Integer getClientID(){
        return clientID;
    }

    public void setClientID(int id){
        this.clientID = id;
    }

    public Integer getHealthProgramID(){
        return healthProgramID;
    }

    public void setHealthProgramID(int id){
        this.healthProgramID = id;
    }

    public List<Integer> getHealthProgramsIDs(){
        return healthProgramIDs;
    }

    public void setHealthProgramIDs(List<Integer> ids){
        this.healthProgramIDs = ids;
    }

}
