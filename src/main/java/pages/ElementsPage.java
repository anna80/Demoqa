package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.ScrollingUtils.scrollToDown;
import static utils.WaitingUtils.waitVisibilityOfElement;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Web Tables')]/parent::li")
    private WebElement webTablesButton;

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement addButton;

    @FindBy(xpath = "//div[@id = 'registration-form-modal']")
    private WebElement registrationForm;

    @FindBy(xpath = "//input[@id = 'age']")
    private WebElement ageField;

    @FindBy(xpath = "//input[@id = 'salary']")
    private WebElement salaryField;

    @FindBy(xpath = "//input[@id = 'department']")
    private WebElement departmentField;

    @FindBy(xpath = "//div[text()='Anna']")
    private WebElement userCreated;

    @FindBy(xpath = "//span[@id='delete-record-4']")
    private WebElement userDelete;

    @FindBy(xpath = "//div[@class='rt-tr-group']//div[@class='rt-td'][4]")
    private List<WebElement> usersSearch;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWebTablesButton() {
        scrollToDown(driver);
        waitVisibilityOfElement(webTablesButton);
        webTablesButton.click();
    }

    public void clickAddButton() {
        waitVisibilityOfElement(addButton);
        addButton.click();
    }

    public boolean isRegistrationVisible() {
        return registrationForm.isDisplayed();
    }

    public void enterAgeField(final String text) {
        waitVisibilityOfElement(ageField);
        ageField.sendKeys(text);
    }

    public void enterSalaryField(final String text) {
        waitVisibilityOfElement(salaryField);
        salaryField.sendKeys(text);
    }

    public void enterDepartmentField(final String text) {
        waitVisibilityOfElement(departmentField);
        departmentField.sendKeys(text);
    }

    public boolean isUserCreatedVisible() {
        waitVisibilityOfElement(userCreated);
        return userCreated.isDisplayed();
    }

    public void clickUserDelete() {
        waitVisibilityOfElement(userDelete);
        userDelete.click();
    }

    public List<WebElement> getEnterUserSearch() {
        return usersSearch;
    }

    public void selectEmailUser(final String email) {
        List<WebElement> users = getEnterUserSearch();
        users.stream()
                .filter(e -> e.getText().equals(email))
                .findAny().get()
                .isDisplayed();
    }
}
