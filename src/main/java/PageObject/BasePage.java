package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by e.dima on 17.7.17.
 */
public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void NavigateHere(){
        driver.navigate().to("http://ru.battleship-game.org/");
    }

    public void NavigateHere(String URL){
        driver.navigate().to(URL);
    }
}
