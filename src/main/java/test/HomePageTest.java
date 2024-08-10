package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.AssertJUnit.assertTrue;

public class HomePageTest {

    @Test

    public void testMakeAppointmentButtonClickable() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        HomePage homePage = new HomePage(driver);
        assertTrue("Make Appointment button should be clickable",
                homePage.makeAppointmentButtonClickable());


        driver.quit();
    }
}
