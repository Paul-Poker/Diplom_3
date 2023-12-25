package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class MainPage {

    private static WebDriver webDriver;
    private final By accountBtn = By.xpath(".//p[text()='Личный Кабинет']");
    private final By enterAccountBtn = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By logoBtn = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By exitBtn = By.xpath(".//button[text()='Выход']");
    private final By bunsBtn = By.xpath(".//span[text()='Булки']/..");
    private final By saucesBtn = By.xpath(".//span[text()='Соусы']/..");
    private final By fillingsBtn = By.xpath(".//span[text()='Начинки']/..");
    private final By mainPageContainer = By.xpath(".//main[contains(@class, 'componentContainer')]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    @Step("Клик на Личный кабинет")
    public MainPage clickAccount() {
        webDriver.findElement(accountBtn).click();
        return this;
    }

    @Step("Клик на Войти в аккаунт")
    public MainPage clickEnterAccount() {
        webDriver.findElement(enterAccountBtn).click();
        return this;
    }

    @Step("Клик на Логотип")
    public void clickLogo() {
        webDriver.findElement(logoBtn).click();
    }


    @Step("Клик на раздел Булочки")
    public void clickBuns() {
        webDriver.findElement(bunsBtn).click();
    }

    @Step("Клик на раздел Соусы")
    public void clickSauces() {
        webDriver.findElement(saucesBtn).click();
    }

    @Step("Клик на раздел Булочки")
    public void clickFilling() {
        webDriver.findElement(fillingsBtn).click();
    }

    @Step("Проверяем выбранный элемент")
    public boolean selectBuns() {
        return webDriver.findElement(bunsBtn).getAttribute("class").contains("current");
    }

    @Step("Проверяем выбранный элемент")
    public boolean selectSauce() {
        return webDriver.findElement(saucesBtn).getAttribute("class").contains("current");
    }

    @Step("Проверяем выбранный элемент")
    public boolean selectFillings() {
        return webDriver.findElement(fillingsBtn).getAttribute("class").contains("current");
    }

    @Step("Клик на кнопку выход")
    public void clickAccountExit() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Выход']")));
        webDriver.findElement(exitBtn).click();
    }

    @Step("Ожидание загрузки Главной страницы")
    public void waitForLoadMainPage() {
        new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(mainPageContainer));
    }


}
