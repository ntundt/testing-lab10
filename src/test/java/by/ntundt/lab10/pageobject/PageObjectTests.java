package by.ntundt.lab10.pageobject;

import com.google.common.collect.Ordering;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageObjectTests {

    @BeforeAll
    static void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\nikit\\Desktop\\geckodriver.exe");
    }

    @Test
    public void sortingTest() {
        List<Double> values = new ProductsPage()
                .openPage()
                .agreeWithCookiesPolicy()
                .applySorting()
                .getValues();

        assertTrue(Ordering.natural().reverse().isOrdered(values));
    }

    @Test
    public void searchTest() {
        final String componentName = "TMS320280023";

        List<String> searchResults = new SearchPage()
                .openPage()
                .agreeWithCookiePolicy()
                .inputQuery(componentName)
                .search()
                .getSearchResults();

        assertTrue(searchResults.stream().anyMatch(searchResult -> searchResult.contains(componentName)));
    }


}
