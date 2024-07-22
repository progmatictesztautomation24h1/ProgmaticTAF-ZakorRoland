import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class FirstExample {

    public static void main(String[] args) throws InterruptedException {
        // Teszt setup/beállítás
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(20000)); //várakozik a Selenium, amíg az oldal töltése teljesen be nem fejeződik
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));  //implicit várakozás, a webelemek interaktálhatóságáig vár
        driver.manage().window().maximize();  //teljes képernyősség teszi a böngésuő ablakot

        // Teszt eset lépései
        driver.get("https://www.idokep.hu/idojaras/Budapest");   //betölti az adott url-t
        //driver.navigate().to("https://www.google.com/maps");
        //driver.navigate().back();               //visszanavigál az időképre
        //driver.navigate().refresh();            //újratölti az oldalt
        Thread.sleep(1000);   //várakoztatom a program futását 1mp.-ig
        WebElement acceptCookieButton = driver.findElement(By.className("css-1wjnr64"));
        acceptCookieButton.click();    //bal egérgombbal egyszer kattintson a gombra
        Thread.sleep(2000);   //várakoztatom a program futását 2mp.-ig

        //WebElement detailedForecastLink = driver.findElement(By.className("more-link")); // option 1
        WebElement detailedForecastLink = driver.findElement(By.linkText("RÉSZLETES ELŐREJELZÉS")); // option 2
        detailedForecastLink.click();
        Thread.sleep(1000);

        WebElement loginMenuItem = driver.findElement(By.xpath("//*[@id=\"menubarDesktop\"]/div/div/nav/ul/li[11]/a/small"));
        loginMenuItem.click();
        Thread.sleep(1000);

        //WebElement userNameInput = driver.findElement(By.id("user")); //option 1
        //WebElement userNameInput = driver.findElement(By.name("user_login"));  //option 2
        //WebElement userNameInput = driver.findElement(By.cssSelector("input[autocomplete='username']"));  //option 3
        WebElement userNameInput = driver.findElement(By.xpath("//*[@id=\"user\"]")); //option 4
        userNameInput.sendKeys("mekkelek");
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.id("loginbutton"));
        loginButton.click();
        Thread.sleep(500); //várok fél mp.-ig

        String actualUrl = driver.getCurrentUrl();  //a weboldal aktuális url-je micsoda
        String actualPageSource = driver.getPageSource(); //elkéri a weboldal aktuális forrását
        //System.out.println(actualPageSource);

        // ASSZERTÁCIÓ (ellenőzés)
        if(actualUrl.equals("https://www.idokep.hu/login.php") && actualPageSource.contains("Elfelejtett jelszó"))
            System.out.println("TEST PASSED");
        else
            System.out.println("TEST FAILED");

        Assert.assertEquals(actualUrl,"https://www.idokep.hu/login2.php","Actual url is not the expected.");  //a 3. opcionális paraméter tartalmhatja azt a hibauzenete amit szeretnénk láttatni, ha az ellenörzés sikertelen
        Assert.assertTrue(actualPageSource.contains("Elfelejtett jelszó"),"Elfelejtett jelszó nincs az oldal forrásában."); // a 2 paraméter opciónális, ha akarjuk használjuk a hibaüzenet megfogalmazására
        //Assert.assertTrue(actualUrl.equals("https://www.idokep.hu/login.php") && actualPageSource.contains("Elfelejtett jelszó"));  //Akkor sikeres ha a zárójelben lévő kifejezés TRUE

        // Teszt bezárása/takarítás
        //driver.close();                         //bezárja a böngésző ablakot
        driver.quit();                            //bezárja a böngészőt és a driver példányt a memóriából
    }
}
