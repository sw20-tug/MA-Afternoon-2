package at.tugraz.ist.ma.games;

class TicTacToeSettings {

    enum GAME_MODE
    {
        PVP,
        PVE
    }

    enum AI_Difficulty
    {
        EASY,
        MEDIUM,
        HARD
    }

    public AI_Difficulty ai_difficulty_;
    public GAME_MODE game_mode_;
    TicTacToe.Tile start_symbol_;


    public TicTacToeSettings()
    {
        ai_difficulty_ = AI_Difficulty.EASY;
        game_mode_ = GAME_MODE.PVP;
        start_symbol_ = TicTacToe.Tile.CROSS;
    }
    public TicTacToeSettings(AI_Difficulty ai_difficulty, GAME_MODE game_mode, TicTacToe.Tile start_symbol)
    {
        ai_difficulty_ = ai_difficulty;
        game_mode_ = game_mode;
        start_symbol_ = start_symbol;
    }

    public void setGameMode( GAME_MODE mode)
    {
        game_mode_ = mode;
    }

    public void setStartingPlayer( TicTacToe.Tile startingPlayer)
    {
        start_symbol_ = startingPlayer;
    }

    public void setAiDifficulty( AI_Difficulty difficulty)
    {
        ai_difficulty_ = difficulty;
    }

    public TicTacToe.Tile getStartingPlayer()
    {
        return start_symbol_;
    }

    public GAME_MODE getGameMode() {
        return game_mode_;
    }

    public AI_Difficulty getAiDifficulty() {
        return ai_difficulty_;
    }
}

