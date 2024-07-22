package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;
    //private final By titleBy = By.tagName("h1");
    private final By titleBy = By.xpath("//h1[contains(text(),'Welcome to Formy')]");
    //private final By autocompleteMenuBy = By.xpath("//a[contains(text(),'Autocomplete')]");
    //private final By autocompleteMenuBy = By.cssSelector("a[href='/autocomplete']");
    //private final By autocompleteMenuBy = By.xpath("a[@href='/autocomplete']");
    private final By autocompleteMenuBy = By.linkText("Autocomplete");
    private final By buttonMenuBy = By.linkText("Buttons");
    private final By checkboxMenuBy = By.linkText("Checkbox");
    private final By dropdownMenuBy = By.linkText("Dropdown");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageLoaded() {
        System.out.println("Check HomePage loaded or not.");
        WebElement title = driver.findElement(titleBy);
        return title.isDisplayed();
    }

    public void clickAutocompleteMenu() {
        System.out.println("Click Autocomplete option from the Menu.");
        WebElement autocompleteMenu = driver.findElement(autocompleteMenuBy);
        autocompleteMenu.click();
    }

    public void clickButtonMenu() {
        WebElement buttonMenu = driver.findElement(buttonMenuBy);
        buttonMenu.click();
    }

    public void clickCheckboxMenu() {
        WebElement checkboxMenu = driver.findElement(checkboxMenuBy);
        checkboxMenu.click();
    }

    public void clickDropdownMenu(){
        WebElement dropdownMenu = driver.findElement(dropdownMenuBy);
        dropdownMenu.click();
    }
}
