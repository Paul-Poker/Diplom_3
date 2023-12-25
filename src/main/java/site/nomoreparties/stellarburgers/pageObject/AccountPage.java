package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class AccountPage {

    private static WebDriver webDriver;
    private final By constructorBtn = By.xpath(".//p[text()='Конструктор']");
    private final By accountContentBox = By.xpath("//*[contains(@class, 'Account_contentBox')]");
    private final By exitBtn = By.xpath("//button[contains(text(), 'Выход')]");
    private final String successLogaut = "https://stellarburgers.nomoreparties.site/login";

    public AccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    @Step("Клик на Конструктор")
    public void clickConstructor() {
        webDriver.findElement(constructorBtn).click();
    }

    @Step("Получение подтверждения логаутв")
    public String successfullLogaut() {
        webDriver.get(successLogaut);
        return webDriver.getCurrentUrl();
    }

    public void clickExitBtn() {
        webDriver.findElement(exitBtn).click();
    }

    public void waitForLoadUserAccountPage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOfElementLocated(accountContentBox));
    }
}

