package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.Loginpage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class EndToEndTest {

    @Test
    public void testEndToEndBookingAndLogout() {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://katalon-demo-cura.herokuapp.com/");
            HomePage homePage = new HomePage(driver);

            homePage.makeAppointmentButtonClickable();

            Loginpage loginPage = new Loginpage(driver);
            loginPage.enterUsername("John Doe");
            loginPage.enterPassword("ThisIsNotAPassword");
            loginPage.clickLogin();

            //ide csak ezt a kettőt vettem fel,a facilitit hogy legyen egy nem mandatori és a dátumot mert az meg kötelező töltendő
            AppointmentPage appointmentPage = new AppointmentPage(driver);
            appointmentPage.selectFacility("Tokyo CURA Healthcare Center");
            appointmentPage.enterVisitDate("12/06/2024");
            appointmentPage.clickBookButton();

            String expectedConfirmation = "Please be informed that your appointment has been booked as following:";
            assertEquals("Booking confirmation should appear", expectedConfirmation, appointmentPage.getConfirmationMessage());

            driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();
            HistoryPage historyPage = new HistoryPage(driver);
            String bookingHistory = historyPage.getBookingFromHistory();
            assertTrue("Booking should appear in history",
                    bookingHistory.contains("Tokyo CURA Healthcare Center"));


            homePage.clickLogoutButton();

            assertTrue("User should be logged out and redirected back to home page.", loginPage.isLoginButtonVisible());

        } finally {

            driver.quit();
        }
    }
}

