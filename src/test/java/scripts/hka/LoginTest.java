package scripts.hka;

import static junit.framework.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.hka.LoginPage;
import pages.hka.SecureAreaPage;
import scripts.GenericTest;
import scripts.TestErrorHandler;

@ExtendWith(TestErrorHandler.class)
public class LoginTest extends GenericTest<LoginPage> {

    @Test
    public void successfulLogin(){
        LoginPage loginPage = controller.clickFormAuthentication();
        loginPage.fillForm();
        SecureAreaPage secureAreaPage = loginPage.clickButton();
        assertTrue("Alert text does not match up!",
                secureAreaPage.getAlertText().contains("You logged into a secure area!"));
    }
}
