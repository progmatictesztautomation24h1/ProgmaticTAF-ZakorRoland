package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ProfilePage;

import static org.testng.AssertJUnit.assertTrue;

public class ProfilePageTest {

    @Test
    public void testProfilePageLoads() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");

        ProfilePage profilePage = new ProfilePage(driver);
        assertTrue("Profile page should load succesfully.",
                profilePage.isProfileSectionDisplayed());

        driver.quit();
    }
}
