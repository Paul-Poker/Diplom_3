package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageObject.MainPage;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
    }

    @Test
    @DisplayName("Переход к разделу Булочкии")
    public void SelectBunsTest() {
        mainPage.clickSauces();
        mainPage.clickBuns();
        mainPage.selectBuns();
        Assert.assertTrue("Булочки выбраны", mainPage.selectBuns());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void selectSaucesTest() {
        mainPage.clickSauces();
        mainPage.selectSauce();
        Assert.assertTrue("Соусы выбраны", mainPage.selectSauce());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void selectFillingsTest() {
        mainPage.clickFilling();
        mainPage.selectFillings();
        Assert.assertTrue("Начинки выбраны", mainPage.selectFillings());
    }
}
