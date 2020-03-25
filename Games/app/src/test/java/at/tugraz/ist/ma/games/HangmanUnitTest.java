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
        assertFalse(hangman.guessLetter('z'));
    }


}

