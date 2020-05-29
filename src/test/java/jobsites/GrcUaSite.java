package jobsites;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import setup.WebDriverInit;

import java.util.ArrayList;
import java.util.List;

public class GrcUaSite {
    private WebDriver driver = WebDriverInit.getWebDriver();
    private String url = "https://grc.ua/";

    @FindBy(css = "input[data-qa='search-input']")
    private WebElement searchInput;

    @FindAll(value = @FindBy(css = "span.g-user-content"))
    private List<WebElement> vacancyTitle;

    public GrcUaSite() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getVacanciesByTitle(String title) {
        driver.get(url);
        searchInput.sendKeys(title);
        searchInput.sendKeys(Keys.ENTER);
        List<WebElement> result = driver.findElements(By.cssSelector("span.g-user-content"));
        System.out.println(result.size());
        List<String> titles = new ArrayList<>();
        for (WebElement el: result) {
            titles.add(el.getText());
        }
        return titles;
    }
}
