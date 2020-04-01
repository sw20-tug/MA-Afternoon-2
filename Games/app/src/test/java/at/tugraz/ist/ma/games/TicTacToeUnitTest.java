package at.tugraz.ist.ma.games;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class HangmanUnitTest {

    private Hangman hangman;

    @Before
    public void initTest()
    {
        hangman = new Hangman("");
    }

    @Test
    public void setNewRandomWordTest()
    {
        hangman.setWord("word");
        assertNotNull(hangman.getWord());
    }
    @Test
    public void checkWordTrueTest()
    {
        hangman.setWord("word");
        assertTrue(hangman.guessWord(hangman.getWord()));
        hangman.setWord("HIGH");
        assertTrue(hangman.guessWord("high"));
    }

    @Test
    public void checkWordFalseTest()
    {
        hangman.setWord("trueWord");
        assertFalse(hangman.guessWord("wrongWord"));
    }

    @Test
    public void guessLetterTest()
    {
        hangman.setWord("test");
        assertTrue(hangman.guessLetter('t'));
        assertTrue(hangman.guessLetter('T'));
        assertFalse(hangman.guessLetter('z'));
    }

    @Test
    public void wrongGuessNumberTest()
    {
        hangman.setWord("Number");
        assertEquals(0, hangman.getNumberOfWrongGuesses());
        hangman.guessLetter('N');
        hangman.guessLetter('x');
        assertEquals(1, hangman.getNumberOfWrongGuesses());
        hangman.guessLetter('z');
        hangman.guessLetter('y');
        assertEquals(3, hangman.getNumberOfWrongGuesses());
    }
}

