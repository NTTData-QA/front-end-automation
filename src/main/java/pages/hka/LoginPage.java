package pages.hka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HerokuApp {

  @FindBy(id = "username")
  WebElement usernameField;

  @FindBy(id = "password")
  WebElement passwordField;

  @FindBy(css = "#login button")
  WebElement loginButton;

  public void fillForm() {
    usernameField.sendKeys("tomsmith");
    passwordField.sendKeys("SuperSecretPassword!");
  }

  public SecureAreaPage clickButton() {
    loginButton.click();
    return new SecureAreaPage();
  }
}
