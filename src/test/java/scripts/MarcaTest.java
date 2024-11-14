package scripts;

import org.junit.jupiter.api.Test;
import pages.Marca;

import static org.hamcrest.Matchers.is;
import static utilities.FrontEndOperation.checkThat;

public class MarcaTest extends GenericTest<Marca> {

    @Test
    public void checkMessageVisibility() {
        controller.acceptCookies();
        controller.fillLogin();
        checkThat("Comparing visible message", controller.isVisible(), is(true));
    }

    @Test
    public void checkErrorMessage() {
        controller.acceptCookies();
        controller.fillLogin();
        controller.compareVisibleMessage();
    }
}
