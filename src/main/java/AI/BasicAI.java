package AI;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * Created by e.dima on 14.7.17.
 */
public class BasicAI {
    private EnemyCell[][] enemyCells;
    private WebElement enemyBoard;
    private int boardSize;
    int i;
    int j;

    public BasicAI(List<WebElement> enemyCellsList, WebElement enemyBoard)
    {
        this.enemyBoard = enemyBoard;
        this.boardSize = enemyCellsList.size() / 2;
        enemyCells = new EnemyCell[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++)
        {
            for (int j = 0; j < boardSize; j++)
            {
                enemyCells[i][j] = new EnemyCell(enemyCellsList.get(i + j), CellStatus.EMPTY.name());
            }
        }
        Random random = new Random();
        i = random.nextInt(boardSize);
        j = random.nextInt(boardSize);
    }

    public void StrikeCell()
    {

        Random random = new Random();
        int i = random.nextInt(boardSize);
        int j = random.nextInt(boardSize);
        if (enemyCells[i][j].cell.isEnabled() && enemyCells[i][j].status==CellStatus.EMPTY.name()) {
            enemyCells[i][j].cell.click();
        }
        if (enemyBoard.isEnabled())
            hitCell(i,j);
    }

    private void hitCell(int i, int j) {
        enemyCells[i][j].status = CellStatus.HIT.name();
        if ((i != 0) && (j != 0) && (i != boardSize - 1) && (j != boardSize - 1)) {
            enemyCells[i + 1][j + 1].status = CellStatus.MISS.name();
            enemyCells[i + 1][j - 1].status = CellStatus.MISS.name();
            enemyCells[i - 1][j + 1].status = CellStatus.MISS.name();
            enemyCells[i - 1][j - 1].status = CellStatus.MISS.name();
        }

        if ((i == 0) && (j == 0))
            enemyCells[i + 1][j + 1].status = CellStatus.MISS.name();

        if ((i == 0) && (j == boardSize - 1))
            enemyCells[i + 1][j - 1].status = CellStatus.MISS.name();

        if ((i == boardSize - 1) && (j == 0))
            enemyCells[i - 1][j + 1].status = CellStatus.MISS.name();

        if ((i == boardSize - 1) && (j == boardSize - 1))
            enemyCells[i - 1][j - 1].status = CellStatus.MISS.name();

        if ((i == 0) && (j != 0) && (j != boardSize - 1)) {
            enemyCells[i + 1][j + 1].status = CellStatus.MISS.name();
            enemyCells[i + 1][j - 1].status = CellStatus.MISS.name();
        }

        if ((i == boardSize - 1) && (j != 0) && (j != boardSize - 1)) {
            enemyCells[i - 1][j + 1].status = CellStatus.MISS.name();
            enemyCells[i - 1][j - 1].status = CellStatus.MISS.name();
        }

        if ((i != 0) && (i != boardSize - 1) && (j == 0)) {
            enemyCells[i + 1][j + 1].status = CellStatus.MISS.name();
            enemyCells[i - 1][j + 1].status = CellStatus.MISS.name();
        }

        if ((i != 0) && (i != boardSize - 1) && (j == boardSize - 1)) {
            enemyCells[i + 1][j - 1].status = CellStatus.MISS.name();
            enemyCells[i - 1][j - 1].status = CellStatus.MISS.name();
        }
    }

}
