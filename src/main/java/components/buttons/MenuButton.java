package components.buttons;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuButton extends AbstractComponent {

    private static final String BUTTON_LOCATOR_PATTERN = "//div[@class='pull-left']//li/a[text()='%s']";
    private String label;
    private By buttonLocator;


    public MenuButton(WebDriver driver,String label) {
        super(driver);
        this.label=label;
        this.buttonLocator =By.xpath(String.format(BUTTON_LOCATOR_PATTERN, label));
    }

    public void click() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(buttonLocator));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
}
