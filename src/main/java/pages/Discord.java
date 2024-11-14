package pages;

import helpers.TextTranslation;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.FrontEndOperation;

import static org.hamcrest.Matchers.is;

public class Discord extends GenericPage {

    @FindBy(className = "login-button-js")
    @AndroidFindBy(
            xpath = "//android.widget.Button[@content-desc=\"Iniciar sesión\"]/android.view.ViewGroup")
    WebElement iniciarSesion;

    @FindBy(id = "uid_7")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"login_login_input\"]")
    WebElement email;

    @FindBy(id = "uid_9")
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"login_password_input\"]")
    WebElement password;

    @FindBy(
            xpath =
                    "//button[@type='submit' and contains(@class, 'button_b83a05') and contains(@class, 'button_dd4f85')]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Iniciar sesión\"]")
    WebElement botonIniciarSesion;

    @FindBy(className = "title_d10a58")
    @AndroidFindBy(xpath = "//android.view.View[@text=\"¡Espera! ¿Eres un ser humano?\"]")
    WebElement textoConfirmacion;

    public void clickIniciarSesion() {
        iniciarSesion.click();
    }

    public void rellenarEmail() {
        FrontEndOperation.waitForVisibility(email);
        email.sendKeys("ejemplo@gmail.com");
    }

    public void rellenarPassword() {
        FrontEndOperation.waitForVisibility(password);
        password.sendKeys("123456");
    }

    public void clickBotonIniciarSesion() {
        FrontEndOperation.clickWhenVisible(botonIniciarSesion);
        FrontEndOperation.waitSeconds(4);
        FrontEndOperation.checkThat(
                "El texto es igual",
                textoConfirmacion.getText(),
                is(TextTranslation.get("textoConfirmacion")));
    }
}
