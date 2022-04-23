package components.buttons;

import org.openqa.selenium.WebDriver;

public class AddWorkoutButton extends MenuButton{

    public static final String SETTINGS_BUTTON_LABEL = "Add Workout";

    public AddWorkoutButton(WebDriver  driver) {
        super(driver, SETTINGS_BUTTON_LABEL);
    }
}
