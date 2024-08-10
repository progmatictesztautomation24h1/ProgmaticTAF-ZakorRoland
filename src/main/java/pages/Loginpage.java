package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
    private final WebDriver driver;

    private final By usernameInput = By.id("txt-username");
    private final By passwordInput = By.id("txt-password");
    private final By loginButton = By.id("btn-login");
    private final By errorMessage = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]");

    public Loginpage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
        System.out.println("Entered username " + username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        System.out.println("Entered password " + password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
        System.out.println("Login button was clicked");
    }

    public String getErrorMessage() {
        return
                driver.findElement(errorMessage).getText();
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(loginButton).isDisplayed();
    }
}

