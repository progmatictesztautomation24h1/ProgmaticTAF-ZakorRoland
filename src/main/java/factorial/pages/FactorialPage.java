package factorial.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FactorialPage {
    private final WebDriver driver;
    private final By calculateButtonLocator = By.xpath("//button");
    private final By inputFieldLocator = By.xpath("//input");
    private final By resultLocator = By.xpath("//*[@id='resultDiv']");

    public FactorialPage(WebDriver driver) {
        this.driver = driver;
        isFactorialPageLoaded();
    }

    private boolean isFactorialPageLoaded() {
        System.out.println("Check FactorialPage page loaded or not.");

     // A másik return utasítással egyenértékű ez itt
     // WebElement calculateButton = driver.findElement(calculateButtonLocator);
     // return calculateButton.isDisplayed();
        return driver.findElement(calculateButtonLocator).isDisplayed();
    }

    public void calculateFactorialWith(String input) {
        WebElement inputField = driver.findElement(inputFieldLocator);
        WebElement calculateButton = driver.findElement(calculateButtonLocator);
        inputField.sendKeys(input);
        calculateButton.click();
    }

    public String getFactorialResult() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(resultLocator).getText().length() != 0;
            }
        });
        return driver.findElement(resultLocator).getText();
    }

}
