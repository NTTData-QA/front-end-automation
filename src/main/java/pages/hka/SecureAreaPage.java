package pages.hka;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;
import static utilities.DriverConfiguration.getDriver;

public class SecureAreaPage {
    private WebDriver driver;

    @FindBy(id = "flash")
    WebElement statusAlert;

    public SecureAreaPage(){
        driver = getDriver();
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Constants.LOW_TIMEOUT)), this);
    }

    public String getAlertText(){
        return statusAlert.getText();
    }
}
