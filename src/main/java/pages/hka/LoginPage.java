package pages.hka;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.DriverConfiguration.getDriver;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "#login button")
    WebElement loginButton;

    public LoginPage(){
        driver = getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public void fillForm(){
        usernameField.sendKeys("tomsmith");
        passwordField.sendKeys("SuperSecretPassword!");
    }

    public SecureAreaPage clickButton(){
        loginButton.click();
        return new SecureAreaPage();
    }
}
