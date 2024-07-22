package formsite;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormSiteWithLocatorsTests extends DriverManager {
    private final By firstNameInputBy = By.id("RESULT_TextField-1");
    private final By lastNameInputBy = By.id("RESULT_TextField-2");
    private final By phoneInputBy = By.id("RESULT_TextField-3");
    private final By countryInputBy = By.id("RESULT_TextField-4");
    private final By cityInputBy = By.id("RESULT_TextField-5");
    private final By emailInputBy = By.id("RESULT_TextField-6");
    private final By maleGenreRadioButtonBy = By.cssSelector("label[for='RESULT_RadioButton-7_0']");
    private final By fridayCheckboxBy = By.cssSelector("label[for='RESULT_CheckBox-8_5']");
    private final By contactTimeDropdownBy = By.id("RESULT_RadioButton-9");
    private final By fileUploadInputBy = By.id("RESULT_FileUpload-10");
    private final By tutorialLinkBy = By.linkText("Software Testing Tutorials");
    private final By submitButtonBy = By.id("FSsubmit");
    private final By errorMsgBy = By.xpath("//h1[contains(text(),'An error has occurred')]");

    @Test
    public void filloutFormTest() {
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys("Elemer");

        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys("Test");

        WebElement phoneInput = driver.findElement(phoneInputBy);
        phoneInput.sendKeys("+36808008000");

        WebElement countryInput = driver.findElement(countryInputBy);
        countryInput.sendKeys("Hungary");

        WebElement cityInput = driver.findElement(cityInputBy);
        cityInput.sendKeys("Budapest");

        WebElement emailInput = driver.findElement(emailInputBy);
        emailInput.sendKeys("vmi@vmi.hu");

        WebElement maleGenreRadioButton = driver.findElement(maleGenreRadioButtonBy);
        maleGenreRadioButton.click();

        WebElement fridayCheckbox = driver.findElement(fridayCheckboxBy);
        fridayCheckbox.click();

        Select contactTimeDropdown = new Select(driver.findElement(contactTimeDropdownBy));
        contactTimeDropdown.selectByVisibleText("Afternoon"); //option 1
        // contactTimeDropdown.selectByValue("Radio-1"); //option 2 - előfeltétel az option html tag-nek legyen value attribútuma
        // contactTimeDropdown.selectByIndex(2);   //option 3 - 0-tól indul az indexelés, az első option tag indexe 0

        WebElement fileUploadInput = driver.findElement(fileUploadInputBy);
        fileUploadInput.sendKeys("/Users/zsszurovecz/Desktop/progmatic/tesztautomatizaló24h1/oktatoi/testautomation/SeleniumBasic/.gitignore");

        //ideiglenes lépés az oldal hibája miatt (storage full hibaüzenet). Visszanavigálunk az előző oldalra
        //driver.navigate().back();  //a böngészőn a vissza gomb megnyomásra kerül

        WebElement tutorialLink = driver.findElement(tutorialLinkBy);
        tutorialLink.click();

        driver.navigate().back();

        WebElement submitButton = driver.findElement(submitButtonBy);
        submitButton.click();

        String actualPageSource = driver.getPageSource();
        //Assert.assertFalse(actualPageSource.contains("An error has occurred")); //ugyanaz: assertTrue(!actualPageSource.contains("..."))

        WebElement errorMsg = driver.findElement(errorMsgBy);
        //System.out.println("Error msg displayed? " + errorMsg.isDisplayed());
        Assert.assertFalse(errorMsg.isDisplayed(),"Error message appeared on the webpage.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://fs2.formsite.com/res/submit");
    }

    @Test
    public void fillFormMandatoryFieldsTest(){
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
        WebElement firstNameInput = driver.findElement(firstNameInputBy);
        firstNameInput.sendKeys("Elemer");

        WebElement lastNameInput = driver.findElement(lastNameInputBy);
        lastNameInput.sendKeys("Test");

        WebElement phoneInput = driver.findElement(phoneInputBy);
        phoneInput.sendKeys("+36808008000");

        WebElement submitButton = driver.findElement(submitButtonBy);
        submitButton.click();

        WebElement errorMsg = driver.findElement(errorMsgBy);
        Assert.assertFalse(errorMsg.isDisplayed(),"Error message appeared on the webpage.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://fs2.formsite.com/res/submit");
    }
}
