package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final WebDriver driver;

    private final By makeAppointmentButton =
            By.id("btn-make-appointment");
    private final By logoutButton = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean makeAppointmentButtonClickable() {
        WebElement button = driver.findElement(makeAppointmentButton);
        return button.isEnabled();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
        System.out.println("Logout button was clicked");
    }


}
