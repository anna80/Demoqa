package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.WaitingUtils.waitForPageLoadComplete;

public class GenderRadioButton extends FormsPage{

    public GenderRadioButton(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'custom-radio')]//label[@class='custom-control-label']")
    private List<WebElement> radioButtonList;

    public void setValue(String value) {
        waitForPageLoadComplete();
        if (value.equals("Male") || value.equals("Female") || value.equals("Other")) {
            for (WebElement element : radioButtonList) {
                if (element.getText().equals(value)) {
                    element.click();
                }
            }
        } //else throw new IllegalArgumentException("Choose correct value from list");
    }
}
