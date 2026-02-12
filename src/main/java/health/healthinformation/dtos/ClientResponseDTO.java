package health.healthinformation.dtos;

import java.time.LocalDate;

public class ClientResponseDTO {

    private int clientID;
    private String clientName; 
    private String phoneNumber;
    private int age;
    private LocalDate createdAT;
    private LocalDate updatedAT;

    public int getClientId(){
        return clientID;
    }

    public void setClientID(int id){
        this.clientID = id ;
    }

    public String getClientName(){
        return clientName;
    }

    public void setClientName(String name){
        this.clientName = name;
    }

   

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String number){
        this.phoneNumber = number;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public LocalDate getCreatedAT(){
        return createdAT;
    }

    public void setCreatedAt(LocalDate date){
        this.createdAT = date; 
    }

    public LocalDate getUpdatedAt(){
        return updatedAT;
    } 

    public void setUpdatedAT(LocalDate date){
        this.updatedAT = date;
    }

}
