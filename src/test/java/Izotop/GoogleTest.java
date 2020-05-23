package Izotop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTest {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void testMethod() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("toyota");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.rc"));
        for (WebElement el: elements) {
            Assert.assertTrue(el.getText().toLowerCase().contains("toyota"));
        }

    }

    @AfterClass
    public void afterMethod() {
        driver.quit();
    }
}
