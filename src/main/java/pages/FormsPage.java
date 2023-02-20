package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.ScrollingUtils.scrollToDown;
import static utils.WaitingUtils.waitVisibilityOfElement;

public class FormsPage extends BasePage {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    private static String FILE_PATH = "C:\\Users\\User\\OneDrive\\Рабочий стол\\qrcode.png";

    @FindBy(xpath = "//li[@id='item-0']/span[text()='Practice Form']")
    private WebElement practiceFormButton;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameText;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameText;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement textEmail;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobileNumberPhone;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthInput;

    @FindBy(xpath = "//option[text()='May']")
    private WebElement mayMonthInput;

    @FindBy(xpath = "//option[@value='1980']")
    private WebElement yearInput;

    @FindBy(xpath = "//div[@aria-label='Choose Monday, May 5th, 1980']")
    private WebElement dateFiveInput;

    @FindBy(xpath = "//label[@class='custom-control-label' and text()='Music']")
    private WebElement hobbiesMusic;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement fileInput;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddressText;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    private WebElement openNewWindow;

    @FindBy(xpath = "//div[contains(@class,'custom-radio')]//label[@class='custom-control-label']")
    private List<WebElement> radioButtonList;

    public void clickPracticeFormButton() {
        waitVisibilityOfElement(practiceFormButton);
        practiceFormButton.click();
        Dimension newDimension = new Dimension(600, 1200);
        driver.manage().window().setSize(newDimension);
    }

    public void enterFirstName(final String firstName) {
        firstNameText.sendKeys(firstName);
    }

    public void enterLastName(final String lastName) {
        lastNameText.sendKeys(lastName);
    }

    public void enterTextEmail(final String emailText) {
        textEmail.sendKeys(emailText);
    }


    public List<WebElement> getFemaleRadioButton() {
        return radioButtonList;
    }

    public void selectFemaleRadioButton(final String gender) {
        List<WebElement> itemsButton = getFemaleRadioButton();
                itemsButton.stream()
                .filter(e -> e.getText().equals(gender))
                        .findAny().get()
                .click();
        scrollToDown(driver);
    }

    public void enterMobileNumber(final String mobileNumber) {
        mobileNumberPhone.sendKeys(mobileNumber);
    }

    public void enterDateOfBirth() {
        waitVisibilityOfElement(dateOfBirthInput);
        dateOfBirthInput.click();
        dateOfBirthInput.clear();
    }

    public void clickMayMonthInput() {
        waitVisibilityOfElement(mayMonthInput);
        mayMonthInput.click();
    }

    public void clickYearInput() {
        waitVisibilityOfElement(yearInput);
        yearInput.click();
    }

    public void clickDateFiveInput() {
        waitVisibilityOfElement(dateFiveInput);
        dateFiveInput.click();
        scrollToDown(driver);
    }

    public void clickHobbiesMusic() {
        waitVisibilityOfElement(hobbiesMusic);
        hobbiesMusic.click();
        scrollToDown(driver);
    }

    public void clickFileInput() {
        fileInput.sendKeys(FILE_PATH);
        fileInput.isDisplayed();
    }

    public void enterCurrentAddressText(final String address) {
        currentAddressText.sendKeys(address);
        scrollToDown(driver);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isOpenNewWindowVisible() {
        waitVisibilityOfElement(openNewWindow);
        return openNewWindow.isDisplayed();
    }
}
