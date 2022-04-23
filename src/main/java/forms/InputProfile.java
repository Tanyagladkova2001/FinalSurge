package forms;

import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputProfile extends AbstractComponent {


    public static final String INPUT_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[contains(@class,'formSep')]//input";

    public static final By CLICK_BODY = By.xpath("//div[@class='main-wrapper']");

    Logger log = LogManager.getLogger(InputProfile.class);

    private String label;
    private By  inputLocator;

    public InputProfile(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void insert(String text) {
        driver.findElement(inputLocator).clear();
        log.info("Insert [{}] into [{}] text",text,"text");
        driver.findElement(inputLocator).sendKeys(text);
    }

    public void insertBirthDay(String text) {
        driver.findElement(inputLocator).clear();
        log.info("Insert [{}] into [{}] text",text,"text");
        driver.findElement(inputLocator).sendKeys(text);
        log.info("Click [{}] button ","click body");
        driver.findElement(CLICK_BODY).click();
    }



}
