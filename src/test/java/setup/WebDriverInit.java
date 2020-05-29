package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    private static WebDriver driver;

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
