package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.ScrollingUtils.scrollToDown;

public class HomePage extends BasePage{

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][2]")
    private WebElement formMenu;

    @FindBy(xpath = "//div[@class='card mt-4 top-card'][1]")
    private WebElement elementMenu;

    public boolean isFormMenuVisible(){
        return formMenu.isDisplayed();
    }

    public void clickFormMenu(){
        scrollToDown(driver);
        formMenu.click();
    }

    public void clickElementMenu(){
        scrollToDown(driver);
        elementMenu.click();
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }


}
