package at.tugraz.ist.ma.games;


import java.util.Random;

class Hangman
{

    private String word_;
    private String guessed_word_         = "";
    private String display_word_         = "";

    private int number_of_wrong_guesses_;
    private String[] word_list_;

    public Hangman(String[] word_list){
        this.word_list_ = word_list;
        Random random = new Random();
        int rnd = random.nextInt(word_list.length);
        this.word_ = word_list[rnd].toLowerCase();

        number_of_wrong_guesses_ = 0;
        initiliazeGuessedWord();
        buildFieldWithSpace();
    }
    //---------------------------------------------------------------------------------------------

    void reset()
    {
        Random random = new Random();
        int rnd = random.nextInt(word_list_.length);
        word_ = word_list_[rnd].toLowerCase();
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
        return word != null && word_.equals(word.toLowerCase());
        //increaseNumberOfWrongGuesses();
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

    public void setWordList(String[] word_list){
        this.word_list_ = word_list;
    }

}
