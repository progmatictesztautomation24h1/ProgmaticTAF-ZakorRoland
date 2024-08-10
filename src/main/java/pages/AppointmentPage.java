package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentPage {
    private final WebDriver driver;

    private final By bookButton = By.id("btn-book-appointment");
    private final By confirmationMessage = By.xpath("/html/body/section/div/div/div[1]");
    private final By facilityDropdown = By.id("combo_facility");
    private final By visitDateInput = By.id("txt_visit_date");
    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFacility(String facility) {
        driver.findElement(facilityDropdown).sendKeys(facility);
        System.out.println("Selected Facility " + facility);
    }

    public void enterVisitDate(String date) {
        driver.findElement(visitDateInput).sendKeys(date);
        System.out.println("Selected date " + date);
    }

    public void clickBookButton() {
        driver.findElement(bookButton).click();
        System.out.println("Book button was clicked");
    }

    public String getConfirmationMessage() {
        String message = driver.findElement(confirmationMessage).getText();
        System.out.println("Confirmation message " + message);
        return message;
    }
}
