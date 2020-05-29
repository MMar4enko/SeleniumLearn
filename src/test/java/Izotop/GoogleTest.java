package Izotop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.WebDriverInit;

import java.util.List;

public class GoogleTest {
    WebDriver driver;
    @FindBy(name = "q")
    private WebElement searchField;
    @BeforeClass
    public void beforeMethod() {
        driver = WebDriverInit.getWebDriver();
        PageFactory.initElements(driver, this);
    }
    @Test
    public void testMethod() {
        driver.get("http://google.com");
        searchField.sendKeys("toyota");
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.rc"));
        for (WebElement el: elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains("toyota"));
        }
    }
    @AfterTest
    public void afterMethod() {
        driver.quit();
    }
}
