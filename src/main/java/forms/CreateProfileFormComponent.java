package forms;

import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateProfileFormComponent extends AbstractComponent {

    private static final By HEADER = By.xpath("//h4[contains(.,'Edit User Profile')]");
    private static final By SAVE_BUTTON =
            By.xpath("//div[contains(@class,'formSep sepH_b')]/input[@value='Save Changes']");

    Logger log = LogManager.getLogger(CreateProfileFormComponent.class);

    public CreateProfileFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean  isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    public void save() {
        WebElement button = driver.findElement(SAVE_BUTTON);
        log.info("Click [{}] button ","save");
        button.click();
    }
}
