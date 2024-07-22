package tutorialspoint.tests;

import core.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import tutorialspoint.pages.StudentRegistrationForm;

public class TutorialsPointTest extends DriverManager {
    @Test
    public void registrationFormTest() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        StudentRegistrationForm studentRegistrationForm = new StudentRegistrationForm(driver);
        studentRegistrationForm.fillNameInput("Gyuri");
        studentRegistrationForm.fillEmailInput("info@gyuri.com");
        studentRegistrationForm.selectGender("Female");
        studentRegistrationForm.fillMobile("1234567890");
        studentRegistrationForm.fillDateOfBirth("1986-11-15");
        studentRegistrationForm.fillSubjects("Subject");
        studentRegistrationForm.selectHobbies("Reading", "Music");
        studentRegistrationForm.uploadPicture("/Users/zsszurovecz/Desktop/progmatic/tesztautomatizaló24h1/oktatoi/testautomation/SeleniumBasic/.gitignore");
        studentRegistrationForm.fillAddress("1134 Budapest Béke tér 5");
        studentRegistrationForm.selectState("Haryana");
        studentRegistrationForm.selectCity("Agra");
        studentRegistrationForm.clickLogin();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Assert.assertTrue(studentRegistrationForm.isLoginClickable());
    }
}
