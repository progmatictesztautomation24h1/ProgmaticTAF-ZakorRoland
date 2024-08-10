package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage {
    private WebDriver driver;

    // Locator for the booking entry
    private By bookingHistoryEntry = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBookingFromHistory() {
        return driver.findElement(bookingHistoryEntry).getText();
    }
}

