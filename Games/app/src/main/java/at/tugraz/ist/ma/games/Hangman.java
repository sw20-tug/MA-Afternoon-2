package at.tugraz.ist.ma.games;

public class Hangman
{
    private String word_;

    public Hangman()
    {
        word_ = "";
    }

    String getWord()
    {
        return word_;
    }

    void setWord(String word)
    {
        word_ = word;
    }


    void setNewRandomWord()
    {
        word_ = "";
    }


    boolean guessWord(String word)
    {
        return true;
    }

    boolean guessLetter(char letter)
    {
        return true;
    }
}
