package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AppointmentPage;

import static org.testng.AssertJUnit.assertEquals;

public class AppointmentPageTest {

    @Test
    public void testBookingAppointment() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.clickBookButton();

        String expectedConfirmation = "Please be informed that your appointment has been booked as following:";
        assertEquals("Booking confirmation should appear", expectedConfirmation, appointmentPage.getConfirmationMessage());

        driver.quit();
    }
}
