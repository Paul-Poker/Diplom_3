package site.nomoreparties.stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver get(String browserName) { //выбор браузера через установку значения в -DbrowserName

        if (browserName == null || browserName.isEmpty()) {
            // если browserName не установлен, используется Chrome по умолчанию
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("Browser undefined");
        }
    }
}
