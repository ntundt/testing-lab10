package by.ntundt.lab10.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {

    private final WebDriver driver = new FirefoxDriver();

    public ProductsPage() { }

    public ProductsPage openPage() {
        driver.get("https://www.ti.com/amplifier-circuit/comparators/products.html");
        return this;
    }

    public ProductsPage agreeWithCookiesPolicy() {
        driver.findElement(new By.ById("consent_prompt_submit")).click();
        return this;
    }

    public ProductsPage applySorting() {
        driver.findElement(new By.ByXPath("//thead[1]/tr[1]/th[5]/span[1]")).click();
        return this;
    }

    public List<Double> getValues() {
        List<WebElement> elements = driver.findElements(new By.ByXPath("//table[@id=\"tblResults\"]/tbody[1]/tr/td[5]/span[1]"));
        return elements.stream().map(element -> Double.valueOf(element.getText())).collect(Collectors.toList());
    }
}