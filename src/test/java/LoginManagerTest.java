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
}
