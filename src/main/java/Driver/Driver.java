package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by e.dima on 14.7.17.
 */
public class Driver {
    private static WebDriver driver;

    public static WebDriver Driver() {
        if (driver == null) {
            driver = new ChromeDriver(DesiredCapabilities.chrome());
            return driver;
        }
        return driver;
    }

    private Driver() {
    }

    public static void killDriver(){
        driver.quit();
        driver = null;
    }
}
