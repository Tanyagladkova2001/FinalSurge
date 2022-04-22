package finalsurge;

import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {


    @Test(description ="Выход из аккаунта")
    public void logoutTest() {
        mainStep
                .openFinalLoginPage()
                .loginWithValidCred()
                .logout()
        ;
    }
}
