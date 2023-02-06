package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import pages.ElementsPage;
import pages.HomePage;

import static manager.DriverManager.getDriver;
import static org.junit.Assert.*;

public class Elements {
    private final HomePage homePage = new PageFactoryManager().getHomePage();
    private final ElementsPage elementPage = new PageFactoryManager().getElementsPage();

    private final WebDriver driver = getDriver();

    @And("Go to Elements menu")
    public void goToElementsMenu() {
        homePage.clickElementMenu();
    }

    @And("Select Web table button")
    public void selectWebTableButton() {
        elementPage.clickWebTablesButton();
    }

    @When("Select Add button")
    public void selectAddButton() {
        elementPage.clickAddButton();
    }

    @And("Visibility Registration Form")
    public void visibilityRegistrationForm() {
        assertTrue(elementPage.isRegistrationVisible());
    }

    @And("Select {string} in field Age")
    public void selectAgeInFieldAge(final String age) {
        elementPage.enterAgeField(age);
    }

    @And("Select {string} in field Salary")
    public void selectSalaryInFieldSalary(final String salary) {
        elementPage.enterSalaryField(salary);
    }

    @And("Select {string} in field Department")
    public void selectDepartmentInFieldDepartment(final String department) {
        elementPage.enterDepartmentField(department);
    }

    @Then("Verify if user is created")
    public void verifyIfUserIsCreated() {
        assertTrue(elementPage.isUserCreatedVisible());
    }

    @And("Delete created user")
    public void deleteCreatedUser() {
        elementPage.clickUserDelete();
    }

    @Then("Verify that user is deleted")
    public void verifyThatUserIsDeleted() {
        assertFalse(elementPage.isUserCreatedVisible());
    }

    @When("Do search by any user {string}")
    public void doSearchByAnyUserName(final String name) {
        elementPage.enterUserSearch(name);
    }

    @Then("Verify if user {string} searchable")
    public void verifyIfUserSearchable(final String expectedText) {
        String foundText = elementPage.getFoundUser();
        assertEquals(foundText, expectedText);
    }
}
