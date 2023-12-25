package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;

public class LoginPage {

    private static WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    private final By emailInputField = By.xpath(".//input[@name='name']");
    private final By passwordInputField =  By.xpath(".//input[@name='Пароль']");
    private final By enterBtn = By.xpath("//button[text()='Войти']");
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final String successLogin = "https://stellarburgers.nomoreparties.site";

    @Step("Клик на Войти")
    public void clickEnterBtn() {
        webDriver.findElement(enterBtn).click();
    }
    @Step("Клик на Восстановить пароль")
    public void clickForgotPasswordLink() {
        webDriver.findElement(forgotPasswordLink).click();
    }
    @Step("Клик на Зарегистрироваться")
    public void clickRegisterLink(){
        webDriver.findElement(registerLink).click();
    }
    @Step("Ввод емейла на странице Логина")
    public void inputEmail(String email) {
        webDriver.findElement(emailInputField).sendKeys(email);
    }
    @Step("Ввод пароля на странице Логина")
    public void inputPassword(String password) {
        webDriver.findElement(passwordInputField).sendKeys(password);
    }

    @Step("Получение подтверждения авторизации")
    public String successfullLogin() {
        webDriver.get(successLogin);
        return webDriver.getCurrentUrl();
    }

    @Step ("Ввод данных для авторизации пользователя")
    public void inputDataForLogin(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickEnterBtn();
    }

}
