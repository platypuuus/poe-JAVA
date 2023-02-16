package fr.aelion.modeles;

public class Person {
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;

    public String greetings(){
        return "\n Bonjour, je m'appelle "+firstName+" "+lastName+". Mon numéro de téléphone est le "+phoneNumber+" et mon email est : "+email+".";
    }
    public Person(String lastName,String firstName,String phoneNumber,String email){
        this.lastName=lastName;
        this.firstName=firstName;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public Person(){
    }

}
