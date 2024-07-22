package google;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTests extends DriverManager {
    private final By cookieButtonBy = By.id("L2AGLb");
    private final By searchFieldBy = By.xpath("//textarea[@title='Keresés']");
    private final By searchFieldByv2 = By.cssSelector("textarea[title='Keresés']");

    @Test
    public void doGoogleSearchTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.google.com/");

        WebElement cookieButton = driver.findElement(cookieButtonBy);
        cookieButton.click();

        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys("weather");
        searchField.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.titleContains("weather"));
        Assert.assertTrue(driver.getPageSource().contains("Találatok"));
    }
}
