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

    private StudentRepository SR = new StudentRepository();

    public LoginManager(String login, String password) {
        this.login = login;
        this.password = password;

    }

    public String login() {
        if (this.login.equals(null) || this.password.equals(null)) {
            return "403 Forbidden";
        }
        return this.SR.findByLoginAndPassword(this.login, this.password) ? "200 0k" : "404 not found";
    }

    public void logout() {
    }
}
