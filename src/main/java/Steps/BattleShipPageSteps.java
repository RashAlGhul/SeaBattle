package Steps;

import AI.BasicAI;
import PageObject.BattleShipPageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by e.dima on 14.7.17.
 */
public class BattleShipPageSteps {
    BattleShipPageObject battleShip;
    BasicAI ai;

    public BattleShipPageSteps(WebDriver driver) {
        battleShip = new BattleShipPageObject(driver);
    }

    public void startGame(){
        battleShip.NavigateHere();
        battleShip.clickRandomTimesOnRandomShipsElement(15);
        battleShip.startGame();
        battleShip.waitForStrike();
    }


    public void playGame()
    {
        ai = new BasicAI(battleShip.getEnemyCells(),battleShip.getEnemyBoard());
        while (true){
            if (!battleShip.isGameOver()) {
                battleShip.waitForStrike();
                ai.StrikeCell();
            }
            else break;
        }
    }

    public boolean isPlayerWin(){
        return battleShip.isPlayerWin();
    }

    public String getErrorMessage(){
        return battleShip.getErrorMessage();
    }
}
