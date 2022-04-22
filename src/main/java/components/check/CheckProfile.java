package components.check;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckProfile extends AbstractComponent {

    public static final String PROFILE_TEXT_DATA_FIELD = "//p[@class='formSep' and contains(.,'%s')]";

    String label;
    By textFieldLocator;

    public CheckProfile(WebDriver driver, String label) {
        super(driver);
        this.label=label;
        this.textFieldLocator=By.xpath(String.format(PROFILE_TEXT_DATA_FIELD,label));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(textFieldLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }


    public String getValue() {
        return driver.findElement(textFieldLocator).getText().split(":")[1].trim();
    }
}
