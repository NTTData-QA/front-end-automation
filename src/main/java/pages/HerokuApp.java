package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hka.LoginPage;
import utilities.Constants;
import utilities.FrontEndOperation;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.DriverConfiguration.getDriver;

public class HerokuApp extends FrontEndOperation {
    private final WebDriver driver;

    @FindBy(linkText = "Form Authentication")
    WebElement formLink;

    public HerokuApp(){
        driver = getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public LoginPage clickFormAuthentication(){
        formLink.click();
        return new LoginPage();
    }
}
