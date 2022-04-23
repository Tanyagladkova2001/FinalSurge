package forms;
import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.FinalLoginPage;

public class CreatedWorkoutComponent extends AbstractComponent {
    public static final String RACE_RESULTS_AND_PEIRCIVED ="//div[@class='formSep' and contains(.,'%s')]";
    public static final By WORKOUT_STATISTICS =By.xpath("//div[@class='formSep' and contains(.,'Workout Statistics')]//span[@class='label label-info']");
    public static final By HOW_I_FELT =By.xpath("//div[@class='formSep' and contains(.,'How I Felt')]//span[@class='label label-success']");
    public static final By MINHR =By.xpath("//p[@class='formSep' and contains(.,'Min HR')]");
    public static final By CALORIES =By.xpath("//p[@class='formSep' and contains(.,'Calories Burned:')]//span");

    String label;
    By textFieldContactLocator;

    Logger log =  LogManager.getLogger(CreatedWorkoutComponent.class);

    public CreatedWorkoutComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldContactLocator = By.xpath(String.format(RACE_RESULTS_AND_PEIRCIVED, label));
    }
    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated((textFieldContactLocator)));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }
    public String getValueRunning() {
        return driver.findElement(textFieldContactLocator).getText().split("Run\n")[1];
    }

    public String getValueWorkoutStatistics() {
        log.info("Get from WorkoutStatistics value");
        return driver.findElement(WORKOUT_STATISTICS).getText();}
    public String getValueHowIFElt() {
        log.info("Get from How I FElt value");
        return driver.findElement(HOW_I_FELT).getText();
    }
    public String getValueCaloriesBurned() {
        log.info("Get  from Calories Burned");
        return driver.findElement(CALORIES).getText().split(": ")[1];
    }
    public String getValueOverallPlace() {
        log.info("Get from Overall Place");
        return driver.findElement(textFieldContactLocator).getText().split("Race Results:\nOverall Place: ")[1].replaceAll("    Age Group Place: 21","");}
    public String getValueAgeGroupPlace() {
        log.info("Get from Age Group Place");
        return driver.findElement(textFieldContactLocator).getText().split("Age Group Place: ")[1];}
    public String getValuePerceivedEffort() {
        log.info("Get from Perceived Effort");
        return driver.findElement(textFieldContactLocator).getText().split("Perceived Effort ")[1];}
    public String getValueMinHR() {
        log.info("Get from Min HR");
        return driver.findElement(MINHR).getText().split("Min HR: ")[1].replaceAll("  \nCalories Burned: 300 kCal","");}
    }

