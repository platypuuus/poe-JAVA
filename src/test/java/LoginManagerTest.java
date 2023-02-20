import fr.aelion.modeles.Student;
import fr.aelion.repositories.StudentRepository;
import fr.aelion.user.LoginManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginManagerTest {
    LoginManager LM ;
    @BeforeEach
    public void setup(){
        LM = new LoginManager("user","mdptest");

    }

    @Test
    @DisplayName("Login and password should be 'user' and 'mdptest'")
    public void haveCredential(){
        assertAll("Credentials",
                ()-> assertEquals("user",LM.getLogin()),
                ()-> assertEquals("mdptest",LM.getPassword())
                );
    }

    @Test
    @DisplayName("Should return 200 0k")
    public void goodCredentials(){
        assertEquals("200 0k",this.LM.login());
    }

    @Test
    @DisplayName("Should return 404")
    public void badCredentials(){
        LoginManager loginManager = new LoginManager("faux","fausAussi");
        assertEquals("404 not found",loginManager.login());
    }
    @Test
    @DisplayName("Student should be logged in")
    public void studentLoggedIn(){
        StudentRepository SR = this.LM.getSR();
        Student stu = SR.findByLoginAndPassword("user","mdptest");

        assertEquals(false, stu.isLoggedIn());

        this.LM.login();

        assertEquals(true, stu.isLoggedIn());
    }
    @Test
    @DisplayName("Student should be logged out")
    public void studentLoggedOut(){
        StudentRepository SR = this.LM.getSR();
        Student stu = SR.findByLoginAndPassword("user","mdptest");

        this.LM.login();
        assertEquals(true, stu.isLoggedIn());

        this.LM.logout();

        assertEquals(false, stu.isLoggedIn());
    }
}
