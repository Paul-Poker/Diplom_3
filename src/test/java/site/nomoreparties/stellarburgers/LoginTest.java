package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pageObject.LoginPage;
import site.nomoreparties.stellarburgers.pageObject.MainPage;
import site.nomoreparties.stellarburgers.pageObject.RegisterPage;
import site.nomoreparties.stellarburgers.user.UserData;
import site.nomoreparties.stellarburgers.user.UserGenerator;

public class LoginTest extends BaseTest{

        private MainPage mainPage;
        private LoginPage loginPage;
        private RegisterPage registerPage;
        private ForgotPasswordPage forgotPasswordPage;
        private UserData user;

        @Before
        public void init() {
            user = UserGenerator.getRandomUser();
            mainPage = new MainPage(webDriver);
            loginPage = new LoginPage(webDriver);
            registerPage = new RegisterPage(webDriver);
            forgotPasswordPage = new ForgotPasswordPage(webDriver);
        }

        @Test
        @DisplayName("Проверка входа по кнопке Войти в аккаунт на главной")
        public void loginUserMainPageEnterAccount(){
            mainPage.clickEnterAccount();
            loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
            Assert.assertEquals("https://stellarburgers.nomoreparties.site/", loginPage.successfullLogin());
        }
        @Test
        @DisplayName("Проверка входа через кнопку Личный кабинет")
        public void loginUserMainPageAccount(){
            mainPage.clickAccount();
            loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
            Assert.assertEquals("https://stellarburgers.nomoreparties.site/", loginPage.successfullLogin());
        }
        @Test
        @DisplayName("Проверка входа через кнопку в форме регистрации")
        public void loginUserRegisterPage(){
            mainPage.clickAccount();
            loginPage.clickRegisterLink();
            registerPage.clickenterLink();
            loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
            Assert.assertEquals("https://stellarburgers.nomoreparties.site/", loginPage.successfullLogin());
        }
        @Test
        @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
        public void loginUserForgotPasswordPage(){
            mainPage.clickAccount();
            loginPage.clickForgotPasswordLink();
            forgotPasswordPage.clickEnterLink();
            loginPage.inputDataForLogin(user.getEmail(), user.getPassword());
            Assert.assertEquals("https://stellarburgers.nomoreparties.site/", loginPage.successfullLogin());
        }

}
