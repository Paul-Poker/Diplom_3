package site.nomoreparties.stellarburgers.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class ForgotPasswordPage {

    private static WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    private final By enterLink = By.xpath("//a[contains(text(), 'Войти')]");

    public void clickEnterLink() {
        webDriver.findElement(enterLink).click();
    }


}
