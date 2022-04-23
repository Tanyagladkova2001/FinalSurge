package pages;

import components.buttons.EditProfileButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends BasePage{

    private static final String BASE_URL = "https://log.finalsurge.com/UserProfile/";
    public static final By HEADER =By.xpath("//h4[contains(.,'User Profile')]");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    Logger log = LogManager.getLogger(SettingsPage.class);

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public  BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void openEditProfileForm(){
        log.info("Click [{}] button ","Edit Profile");
        driver.findElement(EditProfileButton.EDITPROFILE_BUTTON_LABEL).click();
    }
}
