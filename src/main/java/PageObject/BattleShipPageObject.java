package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by e.dima on 14.7.17.
 */
public class BattleShipPageObject extends BasePage {

    public BattleShipPageObject(WebDriver driver){
        super(driver);
    }
    private WebDriverWait wait = new WebDriverWait(driver, 90);

    private By randomShips = By.xpath("//*[contains(text(), 'Случайным образом')]");
    private By playGame = By.xpath("//*[contains(text(), 'Играть')]");
    private By enemyCells = By.xpath("//*[@class='battlefield battlefield__rival']//td");
    private By enemyBoard = By.xpath("//*[@class='battlefield battlefield__rival']");
    private By playerBoard = By.xpath("//*[@class='battlefield battlefield__self']");

    private By enemyShipsHorizontally = By.xpath("//*[@class='battlefield battlefield__rival']//td//div[@class='ship-box ship-box__h']");
    private By enemyShipsVertical = By.xpath("//*[@class='battlefield battlefield__rival']//td//div[@class='ship-box ship-box__v']");
    private By playerShipsHorizontally = By.xpath("//*[@class='battlefield battlefield__self']//td//div[@class='ship-box ship-box__h']");
    private By playerShipsVertical = By.xpath("//*[@class='battlefield battlefield__self']//td//div[@class='ship-box ship-box__v']");
    private By errorMessage = By.xpath("//div[@class='notifications']//div[@class='notification-message']");

    private ArrayList<WebElement> enemyShipsKilled;
    private ArrayList<WebElement> playerShipsKilled;
    public void clickRandomTimesOnRandomShipsElement(int randomShipPositionsCount){
        Random random = new Random();
        for (int i = 0; i < random.nextInt(randomShipPositionsCount)+1; i++) {
            driver.findElement(randomShips).click();
        }
    }

    public void startGame(){
        driver.findElement(playGame).click();
        wait.until(ExpectedConditions.elementToBeClickable(enemyBoard));
    }

    public void waitForStrike()
    {
        wait.until(ExpectedConditions.elementToBeClickable(enemyBoard));
    }

    public List<WebElement> getEnemyCells(){
        return driver.findElements(enemyCells);
    }

    public WebElement getEnemyBoard(){
        return driver.findElement(enemyBoard);
    }

    private WebElement FindElementSafe(By by)
    {
        try
        {
            return driver.findElement(by);
        }
        catch (NoSuchElementException e)
        {
            return null;
        }
    }


    public boolean isGameOver(){
        updateShips();
        WebElement playerBoardElement = FindElementSafe(playerBoard);
        WebElement enemyBoardElement = FindElementSafe(enemyBoard);
        return (enemyShipsKilled.size() == 9 && playerShipsKilled.size() == 9)
                || (playerBoardElement == null && (enemyBoardElement == null));
    }

    private void updateShips(){
        enemyShipsKilled = new ArrayList<>();
        enemyShipsKilled.addAll(driver.findElements(enemyShipsHorizontally));
        enemyShipsKilled.addAll(driver.findElements(enemyShipsVertical));
        playerShipsKilled = new ArrayList<>();
        playerShipsKilled.addAll(driver.findElements(playerShipsHorizontally));
        playerShipsKilled.addAll(driver.findElements(playerShipsVertical));
    }

    public boolean isPlayerWin(){
        return enemyShipsKilled.size() == 9;
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
