package components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfileButton extends MenuButton {

    public static final By EDITPROFILE_BUTTON_LABEL = By.xpath( "//span[contains(.,'Edit Profile')]");

    public EditProfileButton(WebDriver driver) {
        super(driver, String.valueOf(EDITPROFILE_BUTTON_LABEL));
    }
}
