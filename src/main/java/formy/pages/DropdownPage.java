package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By titleBy = By.xpath("//h1[contains(text(),'Dropdown')]");
    private final By dropdownBy = By.id("dropdownMenuButton");
    private final By datePickerBy = By.xpath("(//a[contains(text(),'Datepicker')])[2]"); //A DatePicker textű html tag-ek közül a második a weboldal kódjában
    //private final By datePickerBy = By.xpath("/html/body/div/div/div/a[4]");

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isDropdownPageLoaded() {
        WebElement title = driver.findElement(titleBy);
        return title.isDisplayed();
    }

    public void selectDatePickerFromDropdown() throws InterruptedException {
        WebElement dropdownButton = driver.findElement(dropdownBy);
        dropdownButton.click();
        //Thread.sleep(3000);  //fix várakozás a lenyitott menu betöltéséig
        wait.until(ExpectedConditions.elementToBeClickable(datePickerBy));  //explicit várakozás a lenyitott menu DatePicker elem kattinthatóságáig
        WebElement datePickerOption = driver.findElement(datePickerBy);
        datePickerOption.click();
    }

    public void selectValueFromDropdown(String value) {
        WebElement dropdownButton = driver.findElement(dropdownBy);
        dropdownButton.click();
        By valueBy = By.xpath("(//a[contains(text(),'" + value + "')])[2]");
        WebElement valueOption = driver.findElement(valueBy);
        valueOption.click();
    }
}
