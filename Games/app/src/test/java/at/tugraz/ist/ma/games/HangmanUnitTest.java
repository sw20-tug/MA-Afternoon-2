package at.tugraz.ist.ma.games;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class HangmanUnitTest {



    @Test
    public void guessTest1_aba()
    {
        Hangman hangman = new Hangman("aba");

        hangman.guessCharacter('a');
        assertEquals("a_a", hangman.getCurrentGuessWithoutSpace());
        hangman.guessCharacter('b');
        assertEquals("aba", hangman.getCurrentGuessWithoutSpace());
    }

    @Test
    public void guessTest2_abcde()
    {
        Hangman hangman = new Hangman("abcde");

        hangman.guessCharacter('z');
        assertEquals("_____", hangman.getCurrentGuessWithoutSpace());
        hangman.guessCharacter('y');
        assertEquals("_____", hangman.getCurrentGuessWithoutSpace());
        hangman.guessCharacter('x');
        assertEquals("_____", hangman.getCurrentGuessWithoutSpace());
        hangman.guessCharacter('w');
        assertEquals("_____", hangman.getCurrentGuessWithoutSpace());
        hangman.guessCharacter('v');
        assertEquals("_____", hangman.getCurrentGuessWithoutSpace());
    }


    @Test
    public void setNewRandomWordTest()
    {
        Hangman hangman = new Hangman("word");

        assertNotNull(hangman.getWord());
    }
    @Test
    public void checkWordTrueTest()
    {
        Hangman hangman = new Hangman("HIGH");

        assertTrue(hangman.guessWord(hangman.getWord()));
        assertTrue(hangman.guessWord("high"));
    }

    @Test
    public void checkWordFalseTest()
    {
        Hangman hangman = new Hangman("Number");

        hangman.setWord("trueWord");
        assertFalse(hangman.guessWord("wrongWord"));
    }

    @Test
    public void guessCharacterTest()
    {
        Hangman hangman = new Hangman("test");

        hangman.guessCharacter('t');
        hangman.guessCharacter('k');
        hangman.guessCharacter('z');
        assertEquals(hangman.getNumberOfWrongGuesses(),2);
    }

    @Test
    public void wrongGuessNumberTest()
    {
        Hangman hangman = new Hangman("number");

        assertEquals(0, hangman.getNumberOfWrongGuesses());
        hangman.guessCharacter('n');
        hangman.guessCharacter('x');
        assertEquals(1, hangman.getNumberOfWrongGuesses());
        hangman.guessCharacter('z');
        hangman.guessCharacter('y');
        assertEquals(3, hangman.getNumberOfWrongGuesses());
    }
}

