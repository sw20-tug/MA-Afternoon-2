package at.tugraz.ist.ma.games;


public class Hangman
{
    private String word_;
    private int nr_wrong_guesses_;

    public Hangman(String word)
    {
        if(word != null)
        {
            word_ = word.toLowerCase();
            nr_wrong_guesses_ = 0;
        }
    }

    public String getWord()
    {
        return word_;
    }

    public int getNumberOfWrongGuesses()
    {
        return nr_wrong_guesses_;
    }

    public void setWord(String word)
    {
        if(word != null)
        {
            word_ = word.toLowerCase();
        }
    }

    public boolean guessWord(String word)
    {
        if(word != null && word_.equals(word.toLowerCase()))
        {
            return true;
        }
        increaseNumberOfWrongGuesses();
        return false;
    }

    public boolean guessLetter(char letter)
    {
        if(word_.indexOf(Character.toLowerCase(letter)) != -1)
            return true;
        increaseNumberOfWrongGuesses();
        return false;
    }

    private void increaseNumberOfWrongGuesses()
    {
        nr_wrong_guesses_++;
        return;
    }
}
