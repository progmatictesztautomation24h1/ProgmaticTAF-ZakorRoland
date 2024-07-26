package formy;

import core.DriverManager;
import core.FileReader;
import formy.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormyTests extends DriverManager {
    //https://testng.org/annotations.html annotáció attribútumok leírásához

    @Test(enabled = true, alwaysRun = true, priority = 1, groups = {"regression", "critical"}, description = "TC01: Check if page loaded properly or not.")
    public static void pageLoadedTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
    }


    @DataProvider(name = "formDataProviderLocal")
    public static String[][] formDataProviderLocal()  {
        String[][] data = {{"5500 Gyomaendrőd Álom u 13", "Álom u", "12", "Gyomaendrőd", "Békés", "5500", "Hungary"},
                {"2151 Fót Aszfalt ú 30", "Aszfalt u", "30", "Fót", "Pest", "2151", "Hungary"}};
        return data;
    }

    @DataProvider(name = "formDataProviderFromFile")
    public static Object[][] formDataProviderFromFile()  {
        List<String> rawData = FileReader.readDataFromFile("formData.csv");
        List<List<String>> data = new ArrayList<>();

        for (int i = 0; i < rawData.size(); i++) {
            List<String> tmp = new ArrayList<>();
            tmp.addAll(Arrays.asList(rawData.get(i).split(", ")));
            data.add(tmp);
        }

        Object[][] dataAsArray = new Object[data.size()][data.get(0).size()];

        for (int i = 0; i < data.size(); i++) {
            dataAsArray[i] = data.get(i).toArray();
        }

        return dataAsArray;
    }

    @Test(dataProvider = "formDataProviderFromFile", enabled = true, priority = 2, groups = {"regression"}, description = "TC02: After a page load, click on Autocomplete menuitem and fill out the form. Navigate back to home page.")
    public static void autocompleteTest(String address, String street, String street2, String city, String state, String zip, String country) {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickAutocompleteMenu();

        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        Assert.assertTrue(autoCompletePage.isAutoCompletePageLoaded());
        autoCompletePage.fillAddress(address);
        autoCompletePage.fillStreet(street);
        autoCompletePage.fillStreet2(street2);
        autoCompletePage.fillCity(city);
        autoCompletePage.fillState(state);
        autoCompletePage.fillZip(zip);
        autoCompletePage.fillCountry(country);
        autoCompletePage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());//StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");
    }

    @Test(enabled = false, priority = 3, groups = {"regression"})  //több priority 3 esetén véletlenszerűen válaszja az egyiket, hogy melyiket futtasa hamarabb
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

    @Test(priority = 3, groups = {"regression"})
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

    @Test(priority = 4, groups = {"regression"})
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

    @Test(enabled = true, alwaysRun = true, priority = 100, groups = {"e2e"}, description = "TC100: End to end test")
    public static void endToEndTest() {
        driver.get("https://formy-project.herokuapp.com");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.clickAutocompleteMenu();

        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        Assert.assertTrue(autoCompletePage.isAutoCompletePageLoaded());
        autoCompletePage.fillAddress("5500 Gyomaendrőd Álom u 13");
        autoCompletePage.fillStreet("Álom u");
        autoCompletePage.fillStreet2("12");
        autoCompletePage.fillCity("Gyomaendrőd");
        autoCompletePage.fillState("Békés");
        autoCompletePage.fillZip("5500");
        autoCompletePage.fillCountry("Hungary");
        autoCompletePage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());//StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");

        homePage.clickButtonMenu();

        ButtonPage buttonPage = new ButtonPage(driver);
        Assert.assertTrue(buttonPage.isButtonPageLoaded());
        buttonPage.clickMiddleButton();
        buttonPage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded()); //StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");

        homePage.clickCheckboxMenu();

        CheckboxPage checkboxPage = new CheckboxPage(driver);
        Assert.assertTrue(checkboxPage.isCheckboxPageLoaded());
        checkboxPage.clickCheckbox3Checkbox();
        checkboxPage.clickLogoToNavigateHome();

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded()); //StaleElementReferenceException mert megváltozott a java-ban tárolt oldal a böngészőben látott oldalhoz képest. Ezért újra kell példányosítani ha elnavigáltunk egy oldalról majd visszatérünk rá.
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com/");

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
