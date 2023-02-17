package fr.aelion.modeles;

public class Student {

    public String lastName;
    public String firstName;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
    private Boolean isLoggedIn = false;

    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            isLoggedIn = true;
            return true;
        }
        return false;

    }


    public void logout() {
        isLoggedIn = false;
    }

    public Boolean isLoggedIn() {
        return isLoggedIn;
    }
}
