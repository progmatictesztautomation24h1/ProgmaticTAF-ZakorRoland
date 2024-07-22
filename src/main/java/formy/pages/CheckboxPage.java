package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage {
    private final WebDriver driver;
    private final By checkbox3By = By.id("checkbox-3");
    private final By logoBy = By.id("logo");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCheckboxPageLoaded() {
        WebElement checkbox3 = driver.findElement(checkbox3By);
        return checkbox3.isDisplayed();
    }

    public void clickCheckbox3Checkbox() {
        WebElement checkbox3 = driver.findElement(checkbox3By);
        checkbox3.click();
    }

    public void clickLogoToNavigateHome() {
        WebElement logo = driver.findElement(logoBy);
        logo.click();
    }
}
