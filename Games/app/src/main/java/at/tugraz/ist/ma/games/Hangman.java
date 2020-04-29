package at.tugraz.ist.ma.games;


import android.content.Context;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Hangman
{

    private String word_                 = "";
    private String guessed_word_         = "";
    private String display_word_         = "";
    private Character unknown_character  = '_';
    private Context context_;
    private int number_of_wrong_guesses_ = 0;
    String[] word_list = new String[]{ "Hangmantest", "applejuice", "kitchen","viewer", "kidney" };


    //----------------------------------------------------------------------------------------------
    public Hangman(String word, Context context)
    {
        context_ = context;

        if(word != null)
        {
            word_ = word.toLowerCase();
        }
        else
        {
            Random random = new Random();
            int rnd = random.nextInt(word_list.length);
            word_ = word_list[rnd];
        }
        number_of_wrong_guesses_ = 0;
        initiliazeGuessedWord();
        buildFieldWithSpace();
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
        compareGuessedWithWord();
    }

    //----------------------------------------------------------------------------------------------
    public boolean compareGuessedWithWord()
    {
        if (word_.equals(guessed_word_))
        {
            if(context_ != null) {

                Toast.makeText(context_, "You win!",
                        Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        else
        {
            return false;
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

        if(number_of_wrong_guesses_ == 4 && context_ != null)
        {
            Toast.makeText(context_,"Number of guesses exceeded",
                    Toast.LENGTH_SHORT).show();
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
