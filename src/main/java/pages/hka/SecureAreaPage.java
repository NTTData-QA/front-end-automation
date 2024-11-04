package pages.hka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends HerokuApp {

  @FindBy(id = "flash")
  WebElement statusAlert;

  public String getAlertText() {
    return statusAlert.getText();
  }
}
