package at.tugraz.ist.ma.games;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TicTacToeAIUnitTest {

    private TicTacToeAI ai;

    @Before
    public void initTest()
    {
        ai = new TicTacToeAI(TicTacToe.Tile.CROSS);
    }

    @Test
    public void aiFirstMoveTest()
    {
        for(int i = 0; i < 10; i++){
            ai = new TicTacToeAI(TicTacToe.Tile.CROSS);
            Random rand = new Random();

            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            int index = ai.boardIndexFromRowCol(row, col);

            ai.setTilePlayer(row, col);
            int ai_move = ai.doAIMove();

            assertNotEquals(index, ai_move);
        }

    }

    @Test
    public void aiTestTwoInARowLose()
    {
        ai.setTilePlayer(0, 0);
        ai.setTilePlayer(1,1);

        int ai_move = ai.doAIMove();

        assertEquals(8, ai_move);
    }

    @Test
    public void aiTestForkLose()
    {
        ai.setTilePlayer(1,1);
        ai.setTileAiForTest(2,2);
        ai.setTilePlayer(0 ,0);
        ai.setTileAiForTest(1, 2);
        ai.setTilePlayer(0, 2);

        int ai_move = ai.doAIMove();

        assertTrue(ai_move == 1 || ai_move == 6);
    }

    @Test
    public void aiTestAIPriorityWin()
    {
        ai.setTilePlayer(0,0);
        ai.setTileAiForTest(2, 0);
        ai.setTilePlayer(0,1);
        ai.setTileAiForTest(2, 1);

        int ai_move = ai.doAIMove();

        assertEquals(8, ai_move);
    }

    @Test
    public void aiTestSetTie()
    {
        ai.setTilePlayer(0,0);
        ai.setTilePlayer(0,1);
        ai.setTilePlayer(0,2);
        ai.setTilePlayer(1,0);
        ai.setTilePlayer(1,1);
        ai.setTilePlayer(1,2);
        ai.setTilePlayer(2,1);
        ai.setTilePlayer(2,2);

        int ai_move = ai.doAIMove();

        assertEquals(6, ai_move);
    }

    @Test
    public void fullBoardAiTest()
    {
        ai.setTilePlayer(0,0);
        ai.setTilePlayer(0,1);
        ai.setTilePlayer(0,2);
        ai.setTilePlayer(1,0);
        ai.setTilePlayer(1,1);
        ai.setTilePlayer(1,2);
        ai.setTilePlayer(2,0);
        ai.setTilePlayer(2,1);
        ai.setTilePlayer(2,2);

        int ai_move = ai.doAIMove();

        assertEquals(-1, ai_move);
    }

    @Test
    public void testGetTwoInARow()
    {
        ai.setTilePlayer(0,0);
        ai.setTileAiForTest(1, 0);
        ai.setTilePlayer(2, 0);

        int ai_move = ai.doAIMove();

        assertTrue(ai_move == 4 || ai_move == 5);
    }

    @Test
    public void testOppositeTile(){
        assertEquals(TicTacToe.Tile.CIRCLE, ai.getOpositeTile(TicTacToe.Tile.CROSS));
        assertEquals(TicTacToe.Tile.CROSS, ai.getOpositeTile(TicTacToe.Tile.CIRCLE));
    }

    @Test
    public void testConvertIndex(){
        int index = 5;
        assertEquals(1, ai.getRow(index));
        assertEquals(2, ai.getCol(index));
    }
}

