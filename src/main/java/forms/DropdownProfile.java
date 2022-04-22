package forms;

import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownProfile extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[contains(@class,'formSep')]//select";
    private String label;
    private By dropdownLocator;
    private static final String OPTION_LIST_PATTERN = "//div[contains(@class,'formSep')]" +
                    "//select//option[text()='%s']";

    Logger log = LogManager.getLogger(DropdownProfile.class);

    public DropdownProfile(WebDriver driver,String label) {
        super(driver);
        this.label=label;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN,label));
    }

    @Override
    public boolean isComponentDisplayed()  {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    public void selectOption(String optionName) {
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        log.info("Select [{}]",optionName,"optionName");
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, optionName));
    }
}
