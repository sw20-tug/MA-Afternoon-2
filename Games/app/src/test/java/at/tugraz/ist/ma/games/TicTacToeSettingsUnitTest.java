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

public class TicTacToeSettingsUnitTest {

    private TicTacToeSettings ticTacToeSettings;

    @Before
    public void initTest()
    {
        ticTacToeSettings = new TicTacToeSettings();
    }

    @Test
    public void checkDefaultSettingsTest() {
        assertEquals(ticTacToeSettings.getAiDifficulty(), TicTacToeSettings.AI_Difficulty.EASY);
        assertEquals(ticTacToeSettings.getGameMode(), TicTacToeSettings.GAME_MODE.PVP);
        assertEquals(ticTacToeSettings.getStartingPlayer(), TicTacToe.Tile.CROSS);
    }

    @Test
    public void checkSpecificSettingsTest() {
        TicTacToeSettings ticTacToeSettings_spec = new TicTacToeSettings(TicTacToeSettings.AI_Difficulty.HARD, TicTacToeSettings.GAME_MODE.PVE, TicTacToe.Tile.CIRCLE);

        assertEquals(ticTacToeSettings_spec.getAiDifficulty(), TicTacToeSettings.AI_Difficulty.HARD);
        assertEquals(ticTacToeSettings_spec.getGameMode(), TicTacToeSettings.GAME_MODE.PVE);
        assertEquals(ticTacToeSettings_spec.getStartingPlayer(), TicTacToe.Tile.CIRCLE);
    }

    @Test
    public void checkChangeSettingsTest() {
        assertEquals(ticTacToeSettings.getAiDifficulty(), TicTacToeSettings.AI_Difficulty.EASY);
        assertEquals(ticTacToeSettings.getGameMode(), TicTacToeSettings.GAME_MODE.PVP);
        assertEquals(ticTacToeSettings.getStartingPlayer(), TicTacToe.Tile.CROSS);

        ticTacToeSettings.setAiDifficulty(TicTacToeSettings.AI_Difficulty.HARD);
        ticTacToeSettings.setGameMode(TicTacToeSettings.GAME_MODE.PVE);
        ticTacToeSettings.setStartingPlayer(TicTacToe.Tile.CIRCLE);

        assertEquals(ticTacToeSettings.getAiDifficulty(), TicTacToeSettings.AI_Difficulty.HARD);
        assertEquals(ticTacToeSettings.getGameMode(), TicTacToeSettings.GAME_MODE.PVE);
        assertEquals(ticTacToeSettings.getStartingPlayer(), TicTacToe.Tile.CIRCLE);
    }

}

