package pages.hka;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.GenericPage;

public class HerokuApp extends GenericPage {

  @FindBy(linkText = "Form Authentication")
  public WebElement formLink;

  @FindBy(linkText = "Key Presses")
  public WebElement keyLink;

  @FindBy(linkText = "Dropdown")
  public WebElement dropLink;

  public <T> T clickElement(WebElement element, Class<T> pageClass) {
    element.click();
    try {
      return pageClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException("Failed to create page instance: " + pageClass.getName(), e);
    }
  }
}
