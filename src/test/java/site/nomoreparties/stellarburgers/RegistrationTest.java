package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;
import site.nomoreparties.stellarburgers.user.UserData;
import site.nomoreparties.stellarburgers.user.UserGenerator;

public class RegistrationTest extends BaseTest{

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private UserData user;

    @Before
    public void init() {
        user = UserGenerator.getRandomUser();
        mainPage = new MainPage(webDriver);
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successfullRegisterTest (){
        mainPage.clickAccount();
        loginPage.clickRegisterLink();
        registerPage.register(user.getName(), user.getEmail(), user.getPassword());
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", registerPage.successRegistration());
    }


}
