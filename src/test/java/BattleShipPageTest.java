import Steps.BattleShipPageSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by e.dima on 14.7.17.
 */
public class BattleShipPageTest extends BaseTest {
    private BattleShipPageSteps battleShipSteps;

    @Test
    public void BattleShipPageCheck() {
        battleShipSteps = new BattleShipPageSteps(driver);
        battleShipSteps.startGame();
        battleShipSteps.playGame();
        if (!battleShipSteps.isPlayerWin())
            Assert.fail(battleShipSteps.getErrorMessage());
    }
}
