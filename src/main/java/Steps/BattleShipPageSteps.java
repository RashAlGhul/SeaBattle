package Steps;

import AI.BasicAI;
import PageObject.BattleShipPageObject;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

/**
 * Created by e.dima on 14.7.17.
 */
public class BattleShipPageSteps {
    private BattleShipPageObject battleShip;
    private BasicAI ai;
    private ResourceBundle configData = ResourceBundle.getBundle("ConfigData");

    public BattleShipPageSteps(WebDriver driver) {
        battleShip = new BattleShipPageObject(driver);
    }

    public void startGame() {
        battleShip.NavigateHere(configData.getString("baseUrl"));
        int countRandomTimes = Integer.parseInt(configData.getString("countRandomSetChipLocation"));
        battleShip.clickRandomTimesOnRandomShipsElement(countRandomTimes);
        battleShip.startGame();
        battleShip.waitForStrike();
    }


    public void playGame()
    {
        ai = new BasicAI(battleShip.getEnemyCells(),battleShip.getEnemyBoard());
        int maxCountHit = 100;
        while (maxCountHit>0) {
            if (!battleShip.isGameOver()) {
                battleShip.waitForStrike();
                ai.StrikeCell();
                maxCountHit--;
            } else break;
        }
    }

    public boolean isPlayerWin(){
        return battleShip.isPlayerWin();
    }

    public String getErrorMessage(){
        return battleShip.getErrorMessage();
    }
}
