package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FormsPage;
import pages.HomePage;

import static manager.DriverManager.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.WaitingUtils.waitForAjaxToComplete;
import static utils.WaitingUtils.waitForPageLoadComplete;

public class Forms {
    private final HomePage homePage = new PageFactoryManager().getHomePage();
    private final FormsPage formsPage = new PageFactoryManager().getFormsPage();

    private final WebDriver driver = getDriver();

    @And("Open {string} page")
    public void openPage(final String url) {
        driver.get(url);
    }

    @And("Verify the visible Form menu")
    public void verifyTheVisibleFormMenu() {
        assertTrue("Form menu is visible on the page", homePage.isFormMenuVisible());
    }

    @And("Go to Form menu")
    public void goToFormMenu() {
        homePage.clickFormMenu();
    }

    @And("{string} page is opened")
    public void formsPageIsOpened(final String url) {
        String currentPageUrl = getDriver().getCurrentUrl();
        assertEquals(currentPageUrl, url);
        waitForPageLoadComplete();
    }

    @When("Select Practice Form menu")
    public void selectPracticeFormMenu() {
        formsPage.clickPracticeFormButton();
    }

    @And("Select {string} in field Name")
    public void selectFirstNameInFieldName(final String firstName) {
        formsPage.enterFirstName(firstName);
    }

    @And("Select {string} in field also Name")
    public void selectLastNameInFieldName(final String lastName) {
        formsPage.enterLastName(lastName);
        waitForAjaxToComplete();
    }

    @And("Select {string} in field Email")
    public void selectEmailInFieldEmail(final String email) {
        formsPage.enterTextEmail(email);
    }

    @And("Select Female in field Gender")
    public void selectFemaleInFieldGender() {
        formsPage.clickFemaleRadioButton();
    }

    @And("Select {string} in field Mobile")
    public void selectMobileNumberInFieldMobile(final String mobileNumber) {
        formsPage.enterMobileNumber(mobileNumber);
    }

    @And("Select Date in field Date of birth")
    public void selectDateInFieldDateOfBirth() {
        formsPage.enterDateOfBirth();
        formsPage.clickMayMonthInput();
        formsPage.clickYearInput();
        formsPage.clickDateFiveInput();
    }

    @And("Select Music in field Hobbies")
    public void selectMusicInFieldHobbies() {
        formsPage.clickHobbiesMusic();
    }

    @And("Add {string} in field")
    public void addCurrentAddressInField(final String currentAddress) {
        formsPage.enterCurrentAddressText(currentAddress);
    }

    @And("Click button Submit")
    public void clickButtonSubmit() {
        formsPage.clickSubmitButton();
        waitForPageLoadComplete();
    }

    @Then("Verify if all data is correct in confirmation window")
    public void verifyIfAllDataIsCorrectInConfirmationWindow() {
        Assert.assertTrue(formsPage.isOpenNewWindowVisible());
    }
}
