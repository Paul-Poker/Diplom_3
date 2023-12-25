package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.AccountPage;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.user.UserClient;
import site.nomoreparties.stellarburgers.user.UserData;
import site.nomoreparties.stellarburgers.user.UserGenerator;


public class UserAccountTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private UserData user;
    private UserClient userClient;

    @Before
    public void init() {
        userClient = new UserClient();
        user = UserGenerator.getRandomUser();
        userClient.createUser(user);
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        accountPage = new AccountPage(webDriver);
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    public void accessibilityTransferToAccount() {
        mainPage.clickEnterAccount();
        loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMainPage();
        mainPage.clickAccount();
        accountPage.waitForLoadUserAccountPage();
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор")
    public void accessibilityTranferToConstructorFromAccount() {
        mainPage.clickEnterAccount();
        loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMainPage();
        mainPage.clickAccount();
        accountPage.waitForLoadUserAccountPage();
        accountPage.clickConstructor();
        mainPage.waitForLoadMainPage();
        mainPage.clickLogo();
        mainPage.waitForLoadMainPage();
    }

    @Test
    @DisplayName("Проверка выхода по кнопке Выйти в личном кабинете")
    public void accessibilityExitFromAccount() {
        mainPage.clickEnterAccount();
        loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMainPage();
        mainPage.clickAccount();
        accountPage.waitForLoadUserAccountPage();
        accountPage.clickExitBtn();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", accountPage.successfullLogaut());
    }
}
