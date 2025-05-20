package health.healthinformation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private int clientID;

    private String firstName;

    private String lastName;

    private int age;

    private  String phoneNumber;

    public String clientName(){
        return firstName + " " + lastName;
    }


    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String contact){
        this.phoneNumber = contact;
    }

    public int getClientID(){
        return clientID;
    }

    public void setClientID(int clientID){
        this.clientID = clientID;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String fname){
        this.firstName = fname;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lname){
        this.lastName = lname;
    }

}
