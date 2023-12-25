package site.nomoreparties.stellarburgers.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class ForgotPasswordPage {

    private static WebDriver webDriver;
    private final By enterLink = By.xpath("//a[contains(text(), 'Войти')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    public void clickEnterLink() {
        webDriver.findElement(enterLink).click();
    }


}
