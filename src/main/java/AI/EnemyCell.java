package AI;

import org.openqa.selenium.WebElement;

/**
 * Created by e.dima on 17.7.17.
 */
public class EnemyCell {
    public WebElement cell;
    public String status;

    public EnemyCell(WebElement cell, String status)
    {
        this.cell = cell;
        this.status = status;
    }

    public EnemyCell(WebElement cell)
    {
        this.cell = cell;
        this.status = CellStatus.EMPTY.name();
    }
}
