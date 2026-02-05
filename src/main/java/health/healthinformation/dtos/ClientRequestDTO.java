package health.healthinformation.dtos;

public class ClientRequestDTO {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public String getFirstNmae(){
        return firstName;
    }

    public void setFirstName(String name){
        this.firstName = name; 
    } 

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String name){
        this.lastName = name;
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

    public void setPhoneNumber(String tel){
        this.phoneNumber = tel;
    }


}
