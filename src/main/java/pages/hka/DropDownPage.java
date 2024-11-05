package pages.hka;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends HerokuApp {

  @FindBy(id = "dropdown")
  WebElement dropDrown;

  public void selectFromDropDown(String option) {
    getDropDown().selectByVisibleText(option);
  }

  public List<String> getSelectedTexts() {
    List<WebElement> selectedOptions = getDropDown().getAllSelectedOptions();
    return selectedOptions.stream().map(WebElement::getText).collect(Collectors.toList());
  }

  private Select getDropDown() {
    return new Select(dropDrown);
  }
}
