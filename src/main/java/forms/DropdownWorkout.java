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
import pages.FinalLoginPage;

public class DropdownWorkout extends AbstractComponent {
    private String label;
    private By dropdownLocator;
    public By patterns;

    public static final By DROPDOWN_LOCATOR_PATTERN_TIME = By.xpath("//div//input[@id = 'WorkoutTime']");
    public static final By DROPDOWN_LOCATOR_PATTERN_EFFORT = By.xpath("//select[@id = 'PerEffort']");

    private static final String OPTION_LIST_PATTERN_TIME = "//ul//li[contains(.,'%s')]";
     private static final String OPTION_LIST_PATTERN_EFFORT = "//option[contains(.,'%s')]";

    Logger log = LogManager.getLogger(DropdownWorkout.class);

    public DropdownWorkout(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator=patterns;

    }

    public void selectOption(String optionName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        log.info("Select [{}]","optionName");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(DROPDOWN_LOCATOR_PATTERN_TIME));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
            By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN_TIME,optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
    }

    public void selectOption2( String optionName) {
        log.info("Select [{}]","optionName");
        driver.findElement(DROPDOWN_LOCATOR_PATTERN_EFFORT);
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN_EFFORT,optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();

    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropdownLocator).isDisplayed();
    }
}
