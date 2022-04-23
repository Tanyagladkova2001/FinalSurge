package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditProfilePage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/UserProfile.cshtml?edit=p#profile/";
    public static final By HEADER = By.xpath("//h4[contains(.,'Edit User Profile')] ");


    public EditProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void  waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}
