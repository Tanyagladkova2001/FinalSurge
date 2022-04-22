package forms;

import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectProfile extends AbstractComponent {

    public static final By SELECT_LOCATOR_GENDER=By.xpath("//div[@class='formSep']//label[@class='radio inline']//input[@value='f']");

    public static final By SELECT_LOCATOR_KG =By.xpath("//div[@class='formSep']//label[@class='radio inline']//input[@value='k']");

    Logger log = LogManager.getLogger(SelectProfile.class);

    private String label;
    public By selectLocator;
    public By Locator;

    public SelectProfile(WebDriver driver,String label) {
        super(driver);
        this.label = label;
        this.selectLocator= Locator;
    }
    public boolean isComponentDisplayed(By Locator) {
        return driver.findElement(Locator).isDisplayed();
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public void clickGender() {
        log.info("Click [{}] button ","Female");
        driver.findElement(SELECT_LOCATOR_GENDER).click();
    }
    public void clickKg() {
        log.info("Click [{}] button ","kg");
        driver.findElement(SELECT_LOCATOR_KG).click();
    }
}
