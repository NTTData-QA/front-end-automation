package scripts;

import org.junit.jupiter.api.Test;
import pages.SauceLabs;

public class SauceLabsTest extends GenericTest<SauceLabs> {
  @Test
  public void buySweatshirt() {
    controller.buySweatshirts();
    controller.login();
    controller.checkOut();
  }
}
