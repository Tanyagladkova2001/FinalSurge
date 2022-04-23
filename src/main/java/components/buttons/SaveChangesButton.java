package components.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaveChangesButton extends MenuButton{

    public static final By SAVE_CHANGES_BUTTON_LABEL =By.xpath( "//div[@class='formSep sepH_b']//input[@value='Save Changes'] ");


    public SaveChangesButton(WebDriver driver, String label) {
        super(driver,  String.valueOf(SAVE_CHANGES_BUTTON_LABEL));
    }
}
