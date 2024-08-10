package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private final WebDriver driver;

    private final By profileSection = By.xpath("//*[@id=\"profile\"]/div/div/div/h2");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfileSectionDisplayed() {
        WebElement section = driver.findElement(profileSection);
        return section.isDisplayed();
    }
}
