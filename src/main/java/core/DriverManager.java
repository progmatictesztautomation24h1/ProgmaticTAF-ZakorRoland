package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverManager {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeMethod(groups = {"regression", "critical"})
    protected static void setup() {
        // Teszt setup/beállítás
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000)); //várakozik a Selenium, amíg az oldal töltése teljesen be nem fejeződik
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));  //implicit várakozás, a webelemek interaktálhatóságáig vár
        driver.manage().window().maximize();  //teljes képernyősség teszi a böngésuő ablakot
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit várakozás timeout-ja, egy adott UI element adott eseményére várakoztatok
    }

    @AfterMethod(groups = {"regression", "critical"})
    protected static void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        // Teszt bezárása/takarítás
        //driver.close();                         //bezárja a böngésző ablakot
        driver.quit();                            //bezárja a böngészőt és a driver példányt a memóriából
    }
}
