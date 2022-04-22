package pages;

import components.buttons.SettingsButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class HomePage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/";
    public static final By HEADER = By.xpath("//a[contains(.,'Dashboard')]");
    public static final By HOMEPAGE_WORKOUTS = By.xpath("//div[@id='fade-menu']//a[@class='arrow_down' and contains(.,'Workouts')]");
    public static final By HOMEPAGE_ADDWORKOUT = By.xpath("//div[@id='fade-menu']//a[contains(.,'Add Workout')]");
    public static final By LOGOUT = By.xpath("//a[contains(.,'Logout')]");


    Logger log = LogManager.getLogger(HomePage.class);


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void openSettingsPage() {
        log.info("Click [{}] button ", "Settings");
        driver.findElement(SettingsButton.SETTINGS_BUTTON_LABEL).click();
    }

    public void openAddWorkoutButton() {
        log.info("Imitation of computer mouse");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(HOMEPAGE_WORKOUTS);
        action.moveToElement(we).build().perform();
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HOMEPAGE_ADDWORKOUT));
        driver.findElement(HOMEPAGE_ADDWORKOUT).click();}

        public void clickLogout(){
            log.info("Click [{}]", "Logout");
            driver.findElement(LOGOUT).click();
        }
    }


