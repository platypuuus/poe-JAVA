package fr.aelion.user;

import fr.aelion.modeles.Student;
import fr.aelion.repositories.StudentRepository;

public class LoginManager {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public StudentRepository getSR() {
        return this.SR;
    }

    private StudentRepository SR = new StudentRepository();//Injection de dépendance (DI)

    public LoginManager(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public String login() {
        if (this.login.equals(null) || this.password.equals(null)) {

            return "403 Forbidden";
        }
        Student stu = this.SR.findByLoginAndPassword(this.login,this.password);

        if(stu  instanceof Student){
            stu.isLoggedIn(true);
            return "200 0k";
        }
        return "404 not found";
    }

    public String logout() {

        Student stu = this.SR.findByLoginAndPassword(this.login,this.password);
        if(stu  instanceof Student&&stu.isLoggedIn()){
            stu.isLoggedIn(false);
            return "Succesfully Logout";
        }

        return "The user is not Logged In";
    }
}
