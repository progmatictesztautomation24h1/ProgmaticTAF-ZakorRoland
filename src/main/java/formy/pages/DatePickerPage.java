package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
    private final WebDriver driver;
    private final By titleBy = By.xpath("//h1[contains(text(),'Datepicker')]");
    private final By datepickerInputBy = By.id("datepicker");
    private final By logoBy = By.id("logo");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDatePickerPageLoaded() {
        WebElement title = driver.findElement(titleBy);
        return title.isDisplayed();
    }

    public void fillDatePickerInput(String date) {
        WebElement datePickerInput = driver.findElement(datepickerInputBy);
        datePickerInput.sendKeys(date);
    }

    public void clickLogoToNavigateHome() {
        WebElement logo = driver.findElement(logoBy);
        logo.click();
    }
}
