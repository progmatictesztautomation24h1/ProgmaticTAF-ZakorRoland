package formy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoCompletePage {
    private final WebDriver driver;
    private final By titleBy = By.xpath("//h1[contains(text(),'Autocomplete')]");  //text() adja vissza a tag-ek közötti szöveg értékét
    private final By addressInputBy = By.xpath("//input[@type='text'][@placeholder='Enter address']");
    private final By streetInputBy = By.xpath("//input[@id='street_number'][@placeholder='Street address']");
    private final By streetInput2By = By.xpath("//input[@id='route'][@placeholder='Street address 2']");
    private final By cityInputBy = By.xpath("//input[@id='locality'][@placeholder='City']");
    private final By stateInputBy = By.xpath("//input[@id='administrative_area_level_1'][@placeholder='State']");
    private final By zipInputBy = By.xpath("//input[@id='postal_code'][@placeholder='Zip code']");
    private final By countryInputBy = By.xpath("//input[@id='country'][@placeholder='Country']");
    private final By logoBy = By.id("logo");

    public AutoCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAutoCompletePageLoaded() {
        WebElement titleText = driver.findElement(titleBy);
        return titleText.isDisplayed();
    }

    public void fillAddress(String address) {
        WebElement addressInput = driver.findElement(addressInputBy);
        addressInput.sendKeys(address);
    }

    public void fillStreet(String street) {
        WebElement addressInput = driver.findElement(streetInputBy);
        addressInput.sendKeys(street);
    }

    public void fillStreet2(String street) {
        WebElement addressInput = driver.findElement(streetInput2By);
        addressInput.sendKeys(street);
    }

    public void fillCity(String city) {
        WebElement addressInput = driver.findElement(cityInputBy);
        addressInput.sendKeys(city);
    }

    public void fillState(String state) {
        WebElement addressInput = driver.findElement(stateInputBy);
        addressInput.sendKeys(state);
    }

    public void fillZip(String zip) {
        WebElement addressInput = driver.findElement(zipInputBy);
        addressInput.sendKeys(zip);
    }

    public void fillCountry(String country) {
        WebElement addressInput = driver.findElement(countryInputBy);
        addressInput.sendKeys(country);
    }

    public void clickLogoToNavigateHome(){
        WebElement logo = driver.findElement(logoBy);
        logo.click();
    }
}
