package components.buttons;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsButton extends MenuButton {

    public static final By SETTINGS_BUTTON_LABEL =By.xpath( "//a[text()='Settings']");

    public SettingsButton(WebDriver driver) {
        super(driver, String.valueOf(SETTINGS_BUTTON_LABEL));
    }
}

