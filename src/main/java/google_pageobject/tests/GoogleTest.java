package google_pageobject.tests;

import core.DriverManager;
import google_pageobject.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends DriverManager {
    @Test
    public void doGoogleSearchTest() {
        driver.get("https://www.google.com/");

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver, wait);
        googleSearchPage.acceptCookies();
        googleSearchPage.search("weather");

        Assert.assertTrue(driver.getPageSource().contains("Találatok"));
    }
}