package finalsurge;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.MainStep;
import utils.CapabilitiesGenerator;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected MainStep mainStep;


    @BeforeMethod
    public void  setup() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        mainStep = new MainStep(driver);
        driver.manage().window().setSize(new Dimension(1920, 1080));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
