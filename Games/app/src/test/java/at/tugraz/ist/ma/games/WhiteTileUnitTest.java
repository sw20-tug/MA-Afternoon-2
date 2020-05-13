package at.tugraz.ist.ma.games;

import android.widget.Button;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class WhiteTileUnitTest {


    @Test
    public void checkTouchedWhiteTile()
    {
        WhiteTiles whiteTiles = new WhiteTiles();
        Button btn = new Button(null);
        whiteTiles.addBtnToList(btn);
        assertFalse(whiteTiles.checkCorrectTileAndCount(btn));
    }

    @Test
    public void checkPlayerPoints()
    {
        WhiteTiles whiteTiles = new WhiteTiles();
        Button btn = new Button(null);
        whiteTiles.addBtnToList(btn);
        assertEquals(0,whiteTiles.getPlayer_points());
    }
    @Test
    public void checkPlayerPointsCorrect()
    {
        WhiteTiles whiteTiles = new WhiteTiles(true);
        Button btn = new Button(null);
        whiteTiles.addBtnToList(btn);
        whiteTiles.button_state.set(0, WhiteTiles.TileColor.BLACK);
        whiteTiles.checkCorrectTileAndCount(btn);
        assertEquals(1,whiteTiles.getPlayer_points());
    }

    @Test
    public void restartGame()
    {
        WhiteTiles whiteTiles = new WhiteTiles();
        Button btn = new Button(null);
        whiteTiles.addBtnToList(btn);
        whiteTiles.restartGame();
        assertEquals(0,whiteTiles.getPlayer_points());
    }
    @Test
    public void checkIfAtLeastOneColorEach()
    {
        WhiteTiles whiteTiles = new WhiteTiles(true);
        Button btn = new Button(null);
        Button btn1 = new Button(null);
        whiteTiles.addBtnToList(btn);
        whiteTiles.addBtnToList(btn1);
        whiteTiles.changeField();

        boolean white_tiles = false;
        boolean black_tiles = false;
        for(int i = 0; i < whiteTiles.button_state.size(); i++)
        {
            if(whiteTiles.button_state.get(i).equals(WhiteTiles.TileColor.WHITE))
            {
                white_tiles = true;
            }
            else
            {
                black_tiles = true;
            }
        }

        assertTrue(white_tiles);
        assertTrue(black_tiles);
    }



}

