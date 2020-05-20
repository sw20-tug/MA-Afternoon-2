package at.tugraz.ist.ma.games;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TicTacToeUnitTest {

    private TicTacToe ticTacToe;

    @Before
    public void initTest()
    {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void setTileTest()
    {
        assertTrue(ticTacToe.setTile(1,1, TicTacToe.Tile.CROSS));
        assertEquals(TicTacToe.Tile.CROSS, ticTacToe.getBoard()[1][1]);
    }

    @Test
    public void setTileActivePlayerTest()
    {
        assertTrue(ticTacToe.setTileActivePlayer(1,1));
        assertEquals(TicTacToe.Tile.CROSS, ticTacToe.getBoard()[1][1]);
    }

    @Test
    public void checkWinRowTest()
    {
        ticTacToe.setTile(1,1, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(0, 1, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(2, 1, TicTacToe.Tile.CROSS);
        assertTrue(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
    }
    @Test
    public void checkWinColTest()
    {
        ticTacToe.setTile(0,0, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(0, 1, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(0, 2, TicTacToe.Tile.CROSS);
        assertTrue(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
    }

    @Test
    public void checkWinDiagonalTest()
    {
        ticTacToe.setTile(0,2, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(1,2, TicTacToe.Tile.CIRCLE);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CIRCLE));
        ticTacToe.setTile(1, 1, TicTacToe.Tile.CROSS);
        assertFalse(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
        ticTacToe.setTile(2, 0, TicTacToe.Tile.CROSS);
        assertTrue(ticTacToe.checkWin(TicTacToe.Tile.CROSS));
    }

    @Test
    public void checkWinActivePlayerTest()
    {
        ticTacToe.setTileActivePlayer(1,1);
        assertFalse(ticTacToe.checkWinActivePlayer());
        ticTacToe.setTileActivePlayer(0, 1);
        assertFalse(ticTacToe.checkWinActivePlayer());
        ticTacToe.setTileActivePlayer(2, 1);
        assertTrue(ticTacToe.checkWinActivePlayer());
    }

    @Test
    public void checkOccupied()
    {
        ticTacToe.setTileActivePlayer(1,1);
        assertFalse(ticTacToe.setTileActivePlayer(1,1));
    }

    @Test
    public void activePlayerTest()
    {
        TicTacToe.Tile tile = ticTacToe.getActivePlayer();
        ticTacToe.setTileActivePlayer(1, 1);
        ticTacToe.changePlayer();
        assertNotEquals(TicTacToe.Tile.NONE, tile);
        TicTacToe.Tile tile2 = ticTacToe.getActivePlayer();

        assertNotEquals(tile, tile2);
    }

    @Test
    public void checkTieTest(){
        ticTacToe.setTile(0,0, TicTacToe.Tile.CROSS);
        ticTacToe.setTile(0, 1, TicTacToe.Tile.CIRCLE);
        ticTacToe.setTile(0,2, TicTacToe.Tile.CIRCLE);
        ticTacToe.setTile(1, 0, TicTacToe.Tile.CIRCLE);
        ticTacToe.setTile(1,1, TicTacToe.Tile.CROSS);
        ticTacToe.setTile(1, 2, TicTacToe.Tile.CROSS);
        ticTacToe.setTile(2,0, TicTacToe.Tile.CROSS);
        ticTacToe.setTile(2, 1, TicTacToe.Tile.CROSS);
        ticTacToe.setTile(2, 2, TicTacToe.Tile.CIRCLE);

        assertTrue(ticTacToe.checkTie());
    }
}

