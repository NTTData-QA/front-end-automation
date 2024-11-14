package scripts;

import org.junit.jupiter.api.Test;
import pages.Discord;

public class DiscordTest extends GenericTest<Discord> {

    @Test
    public void logIn() {
        controller.clickIniciarSesion();
        controller.rellenarEmail();
        controller.rellenarPassword();
        controller.clickBotonIniciarSesion();
    }
}
