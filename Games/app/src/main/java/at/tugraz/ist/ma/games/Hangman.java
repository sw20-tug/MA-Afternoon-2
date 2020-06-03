package at.tugraz.ist.ma.games;


import java.util.ArrayList;
import java.util.Random;

class Hangman
{
    final static int HANGMAN_SCORE_INCREASE_PER_WIN  =  1;
    final static int HANGMAN_SCORE_DECREASE_PER_HINT = -3;
    final static int HANGMAN_SCORE_DECREASE_PER_LOSS = -2;

    final static int HANGMAN_NR_OF_MAX_HINTS         =  3;
    final static int HANGMAN_NR_OF_MAX_GUESSES       =  8;

    private String word_;
    private String guessed_word_         = "";
    private String display_word_         = "";

    private int number_of_wrong_guesses_;
    private int number_of_hints_;
    
    private ArrayList<Character> possible_hints_ = new ArrayList<>();
    private String[] word_list_;

    public Hangman(String[] word_list){
        this.word_list_ = word_list;
        Random random = new Random();
        int rnd = random.nextInt(word_list.length);
        this.word_ = word_list[rnd].toLowerCase();

        number_of_hints_         = 0;
        number_of_wrong_guesses_ = 0;

        initializeGuessedWord();
        buildFieldWithSpace();
        initializePossibleHintList();
    }
    //---------------------------------------------------------------------------------------------

    void reset()
    {
        Random random = new Random();
        int rnd = random.nextInt(word_list_.length);
        word_ = word_list_[rnd].toLowerCase();
        guessed_word_ = "";
        display_word_ = "";

        number_of_hints_         = 0;
        number_of_wrong_guesses_ = 0;

        initializeGuessedWord();
        buildFieldWithSpace();
        initializePossibleHintList();
    }
    //----------------------------------------------------------------------------------------------
    private void initializeGuessedWord()
    {
        for (int i = 0; i < word_.length(); i++) {
            char unknown_character = '_';
            guessed_word_ += unknown_character;
        }
    }

    //----------------------------------------------------------------------------------------------
    private void initializePossibleHintList()
    {
        possible_hints_.clear();
        for (Character c : word_.toCharArray())
        {
            c = Character.toUpperCase(c);
            if(!possible_hints_.contains(c))
                possible_hints_.add(c);
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
                if(possible_hints_.contains(letter))
                    possible_hints_.remove(letter);
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
    public Character getHint()
    {
        Random random = new Random();
        int rnd = random.nextInt(possible_hints_.size());

        if(rnd < 0)
            assert false;

        number_of_hints_++;

        return possible_hints_.get(rnd);
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
    public int getNumberOfHints()   { return number_of_hints_ ; }


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
