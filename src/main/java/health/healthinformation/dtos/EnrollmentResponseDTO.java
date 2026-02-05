package health.healthinformation.dtos;

public class EnrollmentResponseDTO {

    private Long enrollmentID;

    private int clientID;
    private String clientName;

    private int programID;
    private String programName;

    public Long getEnrollmentID(){
        return enrollmentID;
    } 

    public void setEnrollmentID(Long id){
        this.enrollmentID = id;
    }

    public int getClientID(){
        return clientID;
    }

    public void setClientID(int id){
        this.clientID = id;
    }

    public String getCientName(){
        return clientName;
    }

    public void setClientName(String name){
        this.clientName = name;
    }

    public int getProgramID(){
        return programID;
    }

    public void setProgramID(int id){
        this.programID =id;
    }

    public String getProgramName(){
        return programName;
    }

    public void setProgramName(String name){
        this.programName = name;
    }

}
