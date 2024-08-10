package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.Loginpage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPageTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

    @Test
    public void testLoginWithIncorectData() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        Loginpage loginpage = new Loginpage(driver);
        loginpage.enterUsername("incorrect user");
        loginpage.enterPassword("incorrect password");
        loginpage.clickLogin();

        String expectedError = "Login failed! Please ensure the username and password are valid.";
        assertEquals("Error message should appear for incorrect login",
                expectedError, loginpage.getErrorMessage());

        driver.quit();
    }
}
