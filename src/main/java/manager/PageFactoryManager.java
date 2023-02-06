package manager;

import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.ElementsPage;
import pages.FormsPage;
import pages.HomePage;

import static manager.DriverManager.getDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(){
        this.driver = getDriver();
    }

    public HomePage getHomePage(){
        return new HomePage(driver);
    }

    public FormsPage getFormsPage(){
        return new FormsPage(driver);
    }

    public ElementsPage getElementsPage(){
        return new ElementsPage(driver);
    }
}
