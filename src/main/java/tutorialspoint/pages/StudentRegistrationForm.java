package tutorialspoint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class StudentRegistrationForm {
    private final WebDriver driver;
    private final By nameInputBy = By.id("name");
    private final By emailInputBy = By.id("email");
    private final By genderRadioButtonsBy = By.xpath("//input[@type='radio']");
    private final By mobileBy = By.id("mobile");
    private final By dateOfBirthBy = By.id("dob");
    private final By subjectsBy = By.id("subjects");
    private final By hobbyCheckboxesBy = By.xpath("//input[@type='checkbox']");
    private final By siblingLabelBy = By.xpath("following-sibling::label");
    private final By pictureUploadBy = By.id("picture");
    //private final By addressInputBy = By.cssSelector("textarea#picture");  //textarea html tag aminek az id attributum értéke picture
    //private final By addressInputBy = By.cssSelector("textarea.form-control");  //textarea html tag aminek a class attributum értéke form-control
    //private final By addressInputBy = By.cssSelector("textarea[id='picture']");
    //private final By addressInputBy = By.cssSelector("textarea[name='picture']");
    //private final By addressInputBy = By.cssSelector("textarea[placeholder='Currend Address']");
    //private final By addressInputBy = By.tagName("textarea");
    //private final By addressInputBy = By.xpath("//textarea[@id=\"picture\"]");  //relative xpath
    //private final By addressInputBy = By.xpath("//textarea[@id='picture']");  //relative xpath
    //private final By addressInputBy = By.xpath("html/body/main/div/div/div[2]/form/div[9]/div/textarea"); //absolute xpath
    //private final By addressInputBy = By.xpath("//textarea[@id='picture']");
    //private final By addressInputBy = By.xpath("//textarea[@name='picture']");
    //private final By addressInputBy = By.xpath("//textarea[@placeholder='Currend Address']");
    //private final By addressInputBy = By.xpath("//textarea[@id='picture'][@placeholder='Currend Address']");
    private final By addressInputBy = By.xpath("//textarea[contains(@placeholder,'Address')]");  //keres olyan textarea html tag-et aminek a placeholder attribútuma tartalmazza azt a kifejezést, hogy Address
    private final By stateDropdownBy = By.id("state");
    private final By cityDropdownBy = By.id("city");
    //private final By loginBtnBy = By.xpath("//*[@type='submit']");
    private final By loginBtnBy = By.xpath("//*[@type='submit'][@value='Login']");

    public StudentRegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameInput(String name) {
        WebElement nameInput = driver.findElement(nameInputBy);
        nameInput.sendKeys(name);
    }

    public void fillEmailInput(String email) {
        WebElement nameInput = driver.findElement(emailInputBy);
        nameInput.sendKeys(email);
    }

    public void selectGender(String gender) {
        List<WebElement> genderButtons = driver.findElements(genderRadioButtonsBy);
        for (WebElement radioBtn : genderButtons) {
            WebElement label = radioBtn.findElement(siblingLabelBy);
            if (label.getText().equals(gender)) {
                radioBtn.click();
                break;
            }
        }
    }

    public void fillMobile(String number) {
        WebElement mobileInput = driver.findElement(mobileBy);
        mobileInput.sendKeys(number);
    }

    public void fillDateOfBirth(String date) {
        WebElement dateOfBirthInput = driver.findElement(dateOfBirthBy);
        dateOfBirthInput.sendKeys(date);
    }

    public void fillSubjects(String subjects) {
        WebElement subjectsInput = driver.findElement(subjectsBy);
        subjectsInput.sendKeys(subjects);
    }

    public void selectHobbies(String... hobbies) {
        List<WebElement> hobbyCheckboxes = driver.findElements(hobbyCheckboxesBy);
        for (WebElement checkBoxBtn : hobbyCheckboxes) {
            WebElement label = checkBoxBtn.findElement(siblingLabelBy);
            if (Arrays.asList(hobbies).contains(label.getText())) {
                checkBoxBtn.click();
            }
        }
    }

    public void uploadPicture(String path) {
        WebElement pictureInput = driver.findElement(pictureUploadBy);
        pictureInput.sendKeys(path);
    }

    public void fillAddress(String address) {
        WebElement addressInput = driver.findElement(addressInputBy);
        addressInput.sendKeys(address);
    }

    public void selectState(String state) {
        Select stateDropdown = new Select(driver.findElement(stateDropdownBy));
        stateDropdown.selectByVisibleText(state); //option 1
        // stateDropdown.selectByValue(state); //option 2 - előfeltétel az option html tag-nek legyen value attribútuma
        // stateDropdown.selectByIndex(4);   //option 3 - 0-tól indul az indexelés, az első option tag indexe 4. Ebben az esetben nem szerencsés, mert a teszt a text-et adja át a metódusnak nem az indexet
    }

    public void selectCity(String city) {
        Select stateDropdown = new Select(driver.findElement(cityDropdownBy));
        stateDropdown.selectByVisibleText(city);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(loginBtnBy);
        loginButton.click();
    }

    public boolean isLoginClickable() {
        WebElement loginButton = driver.findElement(loginBtnBy);
        return loginButton.isDisplayed();
    }
}
