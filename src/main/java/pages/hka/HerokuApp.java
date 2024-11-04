package pages.hka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.GenericPage;

import utilities.enums.Direction;

public class HerokuApp extends GenericPage {

  @FindBy(linkText = "Form Authentication")
  WebElement formLink;

  @FindBy(linkText = "Key Presses")
  WebElement keyLink;

  public LoginPage clickFormAuthentication() {
    formLink.click();
    return new LoginPage();
  }

  public KeyPressesPage clickKeyPressesLink() {
    scrollToElement(keyLink, Direction.UP, false);
    waitForAnimationToFinish();
    keyLink.click();
    return new KeyPressesPage();
  }
}
