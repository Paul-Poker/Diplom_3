package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By accountBtn = By.xpath(".//p[text()='Личный Кабинет']");
//    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By nameIputRegisterField = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private final By emailInputRegisterField = By.xpath(".//label[text()='Email']//following-sibling::input");
    private final By passwordInputRegisterField = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private final By registerBtn = By.xpath("//button[text()='Зарегистрироваться']");
    private final String successRegistration = "https://stellarburgers.nomoreparties.site/login";
    private final By errorText = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Клик на Личный кабинет")
    public void clickAccount() {
        webDriver.findElement(accountBtn).click();
    }

//    @Step("Кликаем на кнопку регитсрации")
//    public RegisterPage clickRegisterButton() {
//        driver.findElement(REGISTER).click();
//        return this;
//    }

    @Step("Ввод имени на странице Регистрации")
    public void nameInput(String name) {
        webDriver.findElement(nameIputRegisterField).click();
        webDriver.findElement(nameIputRegisterField).sendKeys(name);
    }
    @Step("Ввод емейла на странице Регистрации")
    public void emailInput(String email) {
        webDriver.findElement(emailInputRegisterField).click();
        webDriver.findElement(emailInputRegisterField).sendKeys(email);

    }
    @Step("Ввод пароля на странице Регистрации")
    public void passwordInput(String password) {
        webDriver.findElement(passwordInputRegisterField).click();
        webDriver.findElement(passwordInputRegisterField).sendKeys(password);

    }
    @Step("Клик на кнопку Зарегистрироваться")
    public void clickRegisterBtn() {
        webDriver.findElement(registerBtn).click();
    }

    @Step("Получение подтверждения регистрации")
    public String successRegistration() {
        webDriver.get(successRegistration);
        return webDriver.getCurrentUrl();
    }
    @Step("Получение текста ошибки")
    public String errorText() {
        return webDriver.findElement(errorText).getText();
    }

    @Step ("Ввод данных для регистрации пользователя")
    public void register(String name, String email, String password) {
        nameInput(name);
        emailInput(email);
        passwordInput(password);
        clickRegisterBtn();
    }
}
