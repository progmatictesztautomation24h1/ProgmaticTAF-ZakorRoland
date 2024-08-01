package factorial.tests;

import core.DriverManager;
import factorial.pages.FactorialPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest extends DriverManager {

    @Test (description = "TC_Progmatic_JRTA_001", groups = {"regression", "factorialCalculation"})
    public static void factorialTestWith0() {
        driver.get("https://qainterview.pythonanywhere.com/");
        FactorialPage factorialPage = new FactorialPage(driver);
        factorialPage.calculateFactorialWith("0");
        String actualResult = factorialPage.getFactorialResult();
        Assert.assertEquals(actualResult, "The factorial of 0 is: 1" );
    }
}
