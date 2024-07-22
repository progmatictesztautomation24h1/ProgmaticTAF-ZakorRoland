package formsite;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormSiteTests extends DriverManager {

    @Test
    public static void filloutFormTest() {
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
        WebElement firstNameInput = driver.findElement(By.id("RESULT_TextField-1"));
        firstNameInput.sendKeys("Elemer");

        WebElement lastNameInput = driver.findElement(By.id("RESULT_TextField-2"));
        lastNameInput.sendKeys("Test");

        WebElement phoneInput = driver.findElement(By.id("RESULT_TextField-3"));
        phoneInput.sendKeys("+36808008000");

        WebElement countryInput = driver.findElement(By.id("RESULT_TextField-4"));
        countryInput.sendKeys("Hungary");

        WebElement cityInput = driver.findElement(By.id("RESULT_TextField-5"));
        cityInput.sendKeys("Budapest");

        WebElement emailInput = driver.findElement(By.id("RESULT_TextField-6"));
        emailInput.sendKeys("vmi@vmi.hu");

        WebElement maleGenreRadioButton = driver.findElement(By.cssSelector("label[for='RESULT_RadioButton-7_0']"));
        maleGenreRadioButton.click();

        WebElement fridayCheckbox = driver.findElement(By.cssSelector("label[for='RESULT_CheckBox-8_5']"));
        fridayCheckbox.click();

        Select contactTimeDropdown = new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
        contactTimeDropdown.selectByVisibleText("Afternoon"); //option 1
        // contactTimeDropdown.selectByValue("Radio-1"); //option 2 - előfeltétel az option html tag-nek legyen value attribútuma
        // contactTimeDropdown.selectByIndex(2);   //option 3 - 0-tól indul az indexelés, az első option tag indexe 0

        WebElement fileUploadInput = driver.findElement(By.id("RESULT_FileUpload-10"));
        fileUploadInput.sendKeys("/Users/zsszurovecz/Desktop/progmatic/tesztautomatizaló24h1/oktatoi/testautomation/SeleniumBasic/.gitignore");

        //ideiglenes lépés az oldal hibája miatt (storage full hibaüzenet). Visszanavigálunk az előző oldalra
        //driver.navigate().back();  //a böngészőn a vissza gomb megnyomásra kerül

        WebElement tutorialLink = driver.findElement(By.linkText("Software Testing Tutorials"));
        tutorialLink.click();

        driver.navigate().back();

        WebElement submitButton = driver.findElement(By.id("FSsubmit"));
        submitButton.click();

        String actualPageSource = driver.getPageSource();
        //Assert.assertFalse(actualPageSource.contains("An error has occurred")); //ugyanaz: assertTrue(!actualPageSource.contains("..."))

        WebElement errorMsg = driver.findElement(By.xpath("//h1[contains(text(),'An error has occurred')]"));
        //System.out.println("Error msg displayed? " + errorMsg.isDisplayed());
        Assert.assertFalse(errorMsg.isDisplayed(),"Error message appeared on the webpage.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://fs2.formsite.com/res/submit");
    }

    @Test
    public static void fillFormMandatoryFieldsTest(){
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
        WebElement firstNameInput = driver.findElement(By.id("RESULT_TextField-1"));
        firstNameInput.sendKeys("Elemer");

        WebElement lastNameInput = driver.findElement(By.id("RESULT_TextField-2"));
        lastNameInput.sendKeys("Test");

        WebElement phoneInput = driver.findElement(By.id("RESULT_TextField-3"));
        phoneInput.sendKeys("+36808008000");

        WebElement submitButton = driver.findElement(By.id("FSsubmit"));
        submitButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//h1[contains(text(),'An error has occurred')]"));
        Assert.assertFalse(errorMsg.isDisplayed(),"Error message appeared on the webpage.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://fs2.formsite.com/res/submit");
    }
}
