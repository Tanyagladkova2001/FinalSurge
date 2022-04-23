package utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class CapabilitiesGenerator {

    public static  ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath= null;
        if (os.contains("win")) {
            driverPath = PropertyUtils.getEnv("win_driver_path");
            System.setProperty("webdriver.chrome.driver", driverPath);
        } else if (os.contains("mac")) {
            driverPath = PropertyUtils.getEnv("mac_driver_path");
            System.setProperty("webdriver.chrome.driver", driverPath);
        }
        System.out.println("Operational system: " + os + "; Driver path: " + driverPath);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-infobars");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--disable-browser-side-navigation");
        //options.addArguments("--disable-gpu");
        return options;
    }
}
