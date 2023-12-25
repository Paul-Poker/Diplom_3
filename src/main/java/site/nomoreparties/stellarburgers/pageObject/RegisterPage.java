package site.nomoreparties.stellarburgers.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private static WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By nameIputRegisterField = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private final By emailInputRegisterField = By.xpath(".//label[text()='Email']//following-sibling::input");
    private final By passwordInputRegisterField = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private final By registerBtn = By.xpath("//button[text()='Зарегистрироваться']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");
    private final String successRegistration = "https://stellarburgers.nomoreparties.site/login";
    private final By errorText = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Ввод имени на странице Регистрации")
    public void inputName(String name) {
        webDriver.findElement(nameIputRegisterField).click();
        webDriver.findElement(nameIputRegisterField).sendKeys(name);
    }
    @Step("Ввод емейла на странице Регистрации")
    public void inputEmail(String email) {
        webDriver.findElement(emailInputRegisterField).click();
        webDriver.findElement(emailInputRegisterField).sendKeys(email);

    }
    @Step("Ввод пароля на странице Регистрации")
    public void inputPassword(String password) {
        webDriver.findElement(passwordInputRegisterField).click();
        webDriver.findElement(passwordInputRegisterField).sendKeys(password);

    }
    @Step("Клик на кнопку Зарегистрироваться")
    public void clickRegisterBtn() {
        webDriver.findElement(registerBtn).click();
    }

    @Step("Клик на напдись Войти на странице Регистрации")
    public void clickenterLink() {
        webDriver.findElement(enterLink).click();
    }

    @Step("Получение подтверждения регистрации")
    public String successfullRegistration() {
        webDriver.get(successRegistration);
        return webDriver.getCurrentUrl();
    }
    @Step("Получение текста ошибки")
    public String errorText() {
        return webDriver.findElement(errorText).getText();
    }

    @Step ("Ввод данных для регистрации пользователя")
    public void inputDataForRegistration(String name, String email, String password) {
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegisterBtn();
    }
}
