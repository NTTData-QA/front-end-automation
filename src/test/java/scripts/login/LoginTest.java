package scripts.login;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.hka.LoginPage;
import pages.hka.SecureAreaPage;
import scripts.HerokuAppTest;
import scripts.TestErrorHandler;

import static junit.framework.Assert.assertTrue;

@ExtendWith(TestErrorHandler.class)
public class LoginTest extends HerokuAppTest {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.fillForm();
        SecureAreaPage secureAreaPage = loginPage.clickButton();
        assertTrue("Alert text does not match up!",
                secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }
}
