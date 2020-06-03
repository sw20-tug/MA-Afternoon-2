package at.tugraz.ist.ma.games;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HangmanWordEditUnitTest {


    @Test
    public void testAddWord() {
        HangmanWord hmw = new HangmanWord();
        ArrayList<String> tmp = hmw.getValues();

        assertFalse(tmp.contains("blablabla"));
        hmw.addWord("blablabla");
        assertTrue(tmp.contains("blablabla"));
        assertTrue(hmw.doesWordExist("blablabla"));

    }

    @Test
    public void testRemoveWord() {
        HangmanWord hmw = new HangmanWord();

        assertFalse(hmw.doesWordExist("qwer"));
        hmw.addWord("qwer");
        assertTrue(hmw.doesWordExist("qwer"));
        hmw.removeWord(hmw.getValues().indexOf("qwer"));
        assertFalse(hmw.doesWordExist("qwer"));
    }

    @Test
    public void testInitialWordList() {
        HangmanWord hmw = new HangmanWord();

        assertEquals(0, hmw.getValues().size());
    }


}