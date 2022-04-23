package forms;

import components.AbstractComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.FinalLoginPage;

public class InputWorkout extends AbstractComponent {

    public static final String INPUT_LOCATOR_PATTERN =
            "//input[@id='%s']";

    public static final By HOW_I_FEEL= By.xpath("//input[@id='hf_great']");
    public static final By IS_RACE= By.xpath("//input[@id='IsRace']");

    private String label;
    private By inputLocator;

    Logger log =  LogManager.getLogger(InputWorkout.class);

    public InputWorkout(WebDriver driver,String label) {
        super(driver);
        this.label=label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }

   public void clickHowIFeel(){
       log.info("Click [{}] field ","How I Feel");
        driver.findElement(HOW_I_FEEL).click();
   }

    public void clickCheckBoxMarkAsRace(){
       log.info("Click [{}]  checkbox ","Mark As Race");
        driver.findElement(IS_RACE).click();
    }

    @Override
    public boolean isComponentDisplayed()  {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void input(String text) {
       log.info("Click [{}] field ","Is Race");
        driver.findElement(inputLocator).sendKeys(text);
    }

}
