package at.tugraz.ist.ma.games;


import android.util.Log;
import android.webkit.ConsoleMessage;
import android.widget.ImageView;
import android.widget.TextView;

public class Hangman
{
    private String word_                 = "";
    private String guessed_word_         = "";
    private String display_word_         = "";
    private Character unknown_character  = '_';
    private int number_of_wrong_guesses_ = 0;

    //----------------------------------------------------------------------------------------------
    public Hangman(String word)
    {
        if(word != null)
        {
            word_ = word.toLowerCase();
            number_of_wrong_guesses_ = 0;

            initiliazeGuessedWord();
            buildFieldWithSpace();

        }
    }

    //----------------------------------------------------------------------------------------------
    private void initiliazeGuessedWord()
    {
        for (int i = 0; i < word_.length(); i++) {
            guessed_word_ += unknown_character;
        }
    }


    //----------------------------------------------------------------------------------------------
    public void buildFieldWithSpace()
    {
        display_word_ = "";
        for (int i = 0; i < word_.length(); i++) {
            if (i > 0) {
                display_word_+= " ";
            }
            display_word_ += guessed_word_.charAt(i);
        }
    }

    //----------------------------------------------------------------------------------------------
    public void guessCharacter(char letter) {

        char[] guessedLetter = guessed_word_.toCharArray();
        boolean correct_guess = false;
        for (int i = 0; i < word_.length(); i++) {

            if(word_.charAt(i) == letter)  //____ -> a__a
            {
                correct_guess = true;
                guessedLetter[i] = letter;
            }
        }
        if(!correct_guess)
        {
            increaseNumberOfWrongGuesses();
        }

        guessed_word_ = String.valueOf(guessedLetter);
        buildFieldWithSpace();

    }



    //----------------------------------------------------------------------------------------------
    public boolean guessWord(String word)
    {
        if(word != null && word_.equals(word.toLowerCase()))
        {
            return true;
        }
        //increaseNumberOfWrongGuesses();
        return false;
    }

    //----------------------------------------------------------------------------------------------
    private void increaseNumberOfWrongGuesses() { number_of_wrong_guesses_++; }

    //----------------------------------------------------------------------------------------------
    public int getNumberOfWrongGuesses()        { return number_of_wrong_guesses_ ; }

    //----------------------------------------------------------------------------------------------
    public String getCurrentGuess ()            { return display_word_; }

    //----------------------------------------------------------------------------------------------
    public String getCurrentGuessWithoutSpace ()            { return guessed_word_; }

    //----------------------------------------------------------------------------------------------
    public String getWord()                     { return word_; }



    //----------------------------------------------------------------------------------------------
    public void setWord(String word){
        word_ = word;
    }

}
