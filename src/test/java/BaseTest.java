import Driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by e.dima on 17.7.17.
 */
public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver = Driver.Driver();
    }

    @AfterTest
    public void tearDown(){
        Driver.killDriver();
    }
}
