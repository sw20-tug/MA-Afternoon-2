package at.tugraz.ist.ma.games;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreHandlerUnitTest {

    @Before
    public void resetScoreHandler () {ScoreHandler.getInstance().resetScoreToZero();}

    @Test
    public void checkGetInstanceOfScoreHandlerTest ()
    {
        ScoreHandler scoreHandler = ScoreHandler.getInstance();
        assertEquals(scoreHandler, ScoreHandler.getInstance());
    }


    @Test
    public void getScoreTest ()
    {
        ScoreHandler scoreHandler = ScoreHandler.getInstance();
        assertEquals(scoreHandler.getScore(), 0);
    }


    @Test
    public void checkUpdateScoreTest()
    {
        ScoreHandler scoreHandler = ScoreHandler.getInstance();
        scoreHandler.addPointsToScore(5);
        assertEquals(ScoreHandler.getInstance().getScore(), 5);
    }


    @Test
    public void checkResetScoreTest()
    {
        ScoreHandler scoreHandler = ScoreHandler.getInstance();
        scoreHandler.addPointsToScore(1);
        scoreHandler.resetScoreToZero();
        assertEquals(scoreHandler.getScore(),0);
    }

}

