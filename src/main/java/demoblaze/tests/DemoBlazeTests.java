package demoblaze.tests;

import core.DriverManager;
import demoblaze.pages.HomePage;
import org.testng.annotations.Test;

public class DemoBlazeTests extends DriverManager {

    @Test
    public void successfulOrderTest() {
        driver.get("https://www.demoblaze.com/index.html");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickOnProductTitle("Iphone 6 32gb");
        homePage.clickAddToCart();
        homePage.closePopup();
    }
}
