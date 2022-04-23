package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalLoginPage extends BasePage{

    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final By EMAIL = By.cssSelector("[name='login_name']");
    public static final By PASSWORD = By.cssSelector("[name='login_password']");
    public static final By LOGIN_BUTTON = By.xpath("//div/button[contains(.,'Login')]");

    Logger log = LogManager.getLogger(FinalLoginPage.class);

    public  FinalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
     explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void login(String email,String password){
        log.info("Insert [{}] into [{}] email",email,"email");
        driver.findElement(EMAIL).sendKeys(email);
        log.info("Insert [{}] into [{}] password","*******","password");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Click [{}] button ","login");
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
