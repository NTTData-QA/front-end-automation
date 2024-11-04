package pages.hka;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeyPressesPage extends HerokuApp {

  @FindBy(id = "target")
  WebElement inputField;

  @FindBy(id = "result")
  WebElement resultText;

  public void sendTab() {
    inputField.sendKeys(Keys.TAB);
  }

  public void sendEscape() {
    inputField.sendKeys(Keys.ESCAPE);
  }

  public String getResultText() {
    return resultText.getText();
  }
}
