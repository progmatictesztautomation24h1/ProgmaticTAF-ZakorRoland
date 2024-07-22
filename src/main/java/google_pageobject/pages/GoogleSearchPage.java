package google_pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By cookieButtonBy = By.id("L2AGLb");
    private final By searchFieldBy = By.xpath("//textarea[@title='Keresés']");

    public GoogleSearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void search(String searchFor) {
        WebElement searchField = driver.findElement(searchFieldBy);
        searchField.sendKeys(searchFor);
        searchField.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.titleContains(searchFor));
    }

    public void acceptCookies() {
        WebElement cookieButton = driver.findElement(cookieButtonBy);
        cookieButton.click();
    }
}
