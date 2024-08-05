package demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By logoBy = By.id("nava");
    private final By addToCartButtonBy = By.linkText("Add to cart");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        pageLoaded();
    }

    private void pageLoaded() {
        // if (driver.getPageSource().contains(driver.findElement(logoBy).getText()))
        if (driver.findElement(logoBy).isDisplayed())
            System.out.println("Page loaded");
        else
            System.out.println("Page not loaded");
    }

    public void clickOnProductTitle(String title) {
        final By productTitleBy = By.linkText(title); //"Iphone 6 32gb"
        WebElement productTitle = driver.findElement(productTitleBy);
        productTitle.click();
    }

    public void clickAddToCart(){
        WebElement addtoCartButton = driver.findElement(addToCartButtonBy);
        addtoCartButton.click();
    }

    public void closePopup(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();  //close ref: https://www.selenium.dev/documentation/webdriver/interactions/alerts/
    }
}
