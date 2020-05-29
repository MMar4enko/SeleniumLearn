package jobsearch;

import jobsites.GrcUaSite;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import setup.WebDriverInit;

import java.util.List;

public class JobSearchTest {
    WebDriver driver;
    GrcUaSite site;

    @BeforeClass
    public void beforeMethod() {
        driver = WebDriverInit.getWebDriver();
        site = new GrcUaSite();
    }

    @Test
    public void testMethod() {
        List<String> vacancies = site.getVacanciesByTitle("qa");
        System.out.println(vacancies);
    }

    @AfterTest
    public void afterMethod() {
        driver.quit();
    }
}
