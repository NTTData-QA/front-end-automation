package scripts.hka;

import static junit.framework.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.hka.KeyPressesPage;
import scripts.GenericTest;
import scripts.TestErrorHandler;

@ExtendWith(TestErrorHandler.class)
public class KeyPressesTest extends GenericTest<KeyPressesPage> {

  @Test
  public void sendSeveralKeys() {
    KeyPressesPage keyPage = controller.clickElement(controller.keyLink, KeyPressesPage.class);
    keyPage.sendTab();
    assertTrue("Result text does not match up!", keyPage.getResultText().contains("TAB"));
    keyPage.sendEscape();
    assertTrue("Result text does not match up!", keyPage.getResultText().contains("ESCAPE"));
  }
}
