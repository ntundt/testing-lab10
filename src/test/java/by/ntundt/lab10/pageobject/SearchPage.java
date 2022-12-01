package by.ntundt.lab10.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.directory.DirContext;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    private final WebDriver driver = new FirefoxDriver();

    public SearchPage() { }

    public SearchPage openPage() {
        driver.get("https://www.ti.com/sitesearch/en-us/docs/universalsearch.tsp#numberOfResults=25");
        return this;
    }

    public SearchPage agreeWithCookiePolicy() {
        driver.findElement(new By.ById("consent_prompt_submit")).click();
        return this;
    }

    public SearchPage inputQuery(String componentName) {
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//input[@aria-label='Search']")));
        WebElement searchbar = driver.findElement(new By.ByXPath("//input[@aria-label='Search']"));
        searchbar.sendKeys(componentName);
        return this;
    }

    public SearchPage search() {
        driver.findElement(new By.ByXPath("//a[@aria-label='Search']")).click();
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(new By.ByXPath("//div[@class='search-cell']/p/span/span")));
        return this;
    }

    public List<String> getSearchResults() {
        return driver.findElements(new By.ByXPath("//div[@class='search-cell']/p/span/span")).stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
