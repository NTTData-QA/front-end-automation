package scripts.hka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.hka.DropDownPage;
import scripts.GenericTest;
import scripts.TestErrorHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestErrorHandler.class)
public class DropDownTest extends GenericTest<DropDownPage> {

  @Test
  public void testSelectOptionByValue() {
    DropDownPage dropDownPage = controller.clickElement(controller.dropLink, DropDownPage.class);
    String option = "Option 1";
    dropDownPage.selectFromDropDown(option);
    var selectedOptions = dropDownPage.getSelectedTexts();
    assertEquals(selectedOptions.size(), 1, "The size of the selected options is incorrect");
    assertTrue(selectedOptions.contains(option), "Option not selected");
  }
}
