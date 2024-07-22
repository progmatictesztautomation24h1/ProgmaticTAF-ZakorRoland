package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonPage {
    private final WebDriver driver;
    private final By primaryButtonBy = By.xpath("//button[contains(text(),'Primary')]");
    private final By middleButtonBy = By.xpath("//button[contains(text(),'Middle')]");
    private final By logoBy = By.id("logo");

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isButtonPageLoaded() {
        WebElement primaryButton = driver.findElement(primaryButtonBy);
        return primaryButton.isDisplayed();
    }

    public void clickMiddleButton() {
        WebElement middleButton = driver.findElement(middleButtonBy);
        middleButton.click();
    }

    public void clickLogoToNavigateHome() {
        WebElement logo = driver.findElement(logoBy);
        logo.click();
    }
}
