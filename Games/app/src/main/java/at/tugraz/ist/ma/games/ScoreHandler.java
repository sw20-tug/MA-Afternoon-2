package at.tugraz.ist.ma.games;

class ScoreHandler
{
    private static ScoreHandler single_instance = null;
    private int score;

    private ScoreHandler()
    {
       score = 0;
    }

    static ScoreHandler getInstance()
    {
        if (single_instance == null)
            single_instance = new ScoreHandler();

        return single_instance;
    }

    void addPointsToScore(int points)
    {
        this.score += points;
    }

    public int getScore() {
        return score;
    }
}
