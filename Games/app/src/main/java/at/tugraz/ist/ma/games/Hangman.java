package at.tugraz.ist.ma.games;


import java.util.Random;

class Hangman
{
    final static int HANGMAN_SCORE_INCREASE_PER_WIN  =  1;
    final static int HANGMAN_SCORE_DECREASE_PER_HINT = -3;
    final static int HANGMAN_SCORE_DECREASE_PER_LOSS = -2;

    private String word_;
    private String guessed_word_         = "";
    private String display_word_         = "";

    private int number_of_wrong_guesses_;
    private final String[] word_list = new String[]{ "hangmantest", "applejuice", "kitchen","viewer", "kidney" };


    //----------------------------------------------------------------------------------------------
    public Hangman(String word)
    {
        if(word != null)
        {
            word_ = word.toLowerCase();
        }
        else
        {
            Random random = new Random();
            int rnd = random.nextInt(word_list.length);
            word_ = word_list[rnd].toLowerCase();
        }
        number_of_wrong_guesses_ = 0;
        initiliazeGuessedWord();
        buildFieldWithSpace();
    }

    void reset()
    {
        Random random = new Random();
        int rnd = random.nextInt(word_list.length);
        word_ = word_list[rnd].toLowerCase();
        guessed_word_ = "";
        display_word_ = "";

        number_of_wrong_guesses_ = 0;
        initiliazeGuessedWord();
        buildFieldWithSpace();
    }
    //----------------------------------------------------------------------------------------------
    private void initiliazeGuessedWord()
    {
        for (int i = 0; i < word_.length(); i++) {
            Character unknown_character = '_';
            guessed_word_ += unknown_character;
        }
    }


    //----------------------------------------------------------------------------------------------
    private void buildFieldWithSpace()
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
    public boolean isWordCorrect()
    {
        return word_.equals(guessed_word_);
    }

    //----------------------------------------------------------------------------------------------
    public void guessCharacter(char letter) {

        char[] guessedLetter = guessed_word_.toCharArray();
        boolean correct_guess = false;
        for (int i = 0; i < word_.length(); i++) {

            if(word_.charAt(i) == letter)
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
        return word != null && word_.equals(word.toLowerCase());
    }

    //----------------------------------------------------------------------------------------------
    private void increaseNumberOfWrongGuesses() {
        number_of_wrong_guesses_++;
    }

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
