package at.tugraz.ist.ma.games;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TicTacToeAITest {

    private TicTacToeAI ai;

    @Before
    public void initTest()
    {
        ai = new TicTacToeAI(TicTacToe.Tile.CROSS);
    }

}

