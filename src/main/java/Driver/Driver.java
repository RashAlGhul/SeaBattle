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

    public static WebDriver Driver(String driverType) {
        if (driver == null)
            switch (driverType) {
                case "FIREFOX":
                    DesiredCapabilities capabilities= DesiredCapabilities.firefox();
                    driver = new FirefoxDriver(capabilities);
                    break;
                case "CHROME":
                    driver = new ChromeDriver(DesiredCapabilities.chrome());
                    break;
                default:
                    driver = new ChromeDriver();
            }
        return driver;
    }

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
