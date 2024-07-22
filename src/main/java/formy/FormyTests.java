package formy;

import core.DriverManager;
import formy.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormyTests extends DriverManager {

    @Test
    public static void pageLoadedTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
    }

    @Test
    public static void autocompleteTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickAutocompleteMenu();

        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        Assert.assertTrue(autoCompletePage.isAutoCompletePageLoaded());
        autoCompletePage.fillAddress("5500 Gyomaendrőd Álom utca 12");
        autoCompletePage.fillStreet("Álom utca");
        autoCompletePage.fillStreet2("12");
        autoCompletePage.fillCity("Gyomaendrőd");
        autoCompletePage.fillState("Bekes");
        autoCompletePage.fillZip("5500");
        autoCompletePage.fillCountry("Hungary");
        autoCompletePage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());//StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");
    }

    @Test
    public static void buttonTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickButtonMenu();

        ButtonPage buttonPage = new ButtonPage(driver);
        Assert.assertTrue(buttonPage.isButtonPageLoaded());
        buttonPage.clickMiddleButton();
        buttonPage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded()); //StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");
    }

    @Test
    public static void checkboxTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickCheckboxMenu();

        CheckboxPage buttonPage = new CheckboxPage(driver);
        Assert.assertTrue(buttonPage.isCheckboxPageLoaded());
        buttonPage.clickCheckbox3Checkbox();
        buttonPage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded()); //StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");
    }

    @Test
    public static void dropdownAndDatePickerTest() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickDropdownMenu();

        DropdownPage dropdownPage = new DropdownPage(driver, wait);
        Assert.assertTrue(dropdownPage.isDropdownPageLoaded());
        //dropdownPage.selectDatePickerFromDropdown();  //version 1
        dropdownPage.selectValueFromDropdown("Datepicker");  //version 2

        DatePickerPage datePickerPage = new DatePickerPage(driver);
        Assert.assertTrue(datePickerPage.isDatePickerPageLoaded());
        datePickerPage.fillDatePickerInput("07/17/2024");
        datePickerPage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded()); //StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");
    }
}
