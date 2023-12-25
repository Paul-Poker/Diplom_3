package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.user.UserClient;

import java.time.Duration;

public class BaseTest {
    static WebDriver webDriver;
    private String accessToken;

    @Before
    public void setUp() {
        String browserName = System.getProperty("browserName"); //выбор браузера через установку -DbrowserName
        webDriver = WebDriverFactory.get(browserName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    public void deleteUser() {
        if (accessToken != null) {
            UserClient.deleteUser(accessToken);
        }
    }
}
