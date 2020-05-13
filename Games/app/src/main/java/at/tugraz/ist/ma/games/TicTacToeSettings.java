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

    private AI_Difficulty ai_difficulty_;
    private GAME_MODE game_mode_;
    private TicTacToe.Tile start_symbol_;


    TicTacToeSettings()
    {
        ai_difficulty_ = AI_Difficulty.EASY;
        game_mode_ = GAME_MODE.PVP;
        start_symbol_ = TicTacToe.Tile.CROSS;
    }
    TicTacToeSettings(AI_Difficulty ai_difficulty, GAME_MODE game_mode, TicTacToe.Tile start_symbol)
    {
        ai_difficulty_ = ai_difficulty;
        game_mode_ = game_mode;
        start_symbol_ = start_symbol;
    }

    void setGameMode(GAME_MODE mode)
    {
        game_mode_ = mode;
    }

    void setStartingPlayer(TicTacToe.Tile startingPlayer)
    {
        start_symbol_ = startingPlayer;
    }

    void setAiDifficulty(AI_Difficulty difficulty)
    {
        ai_difficulty_ = difficulty;
    }

    TicTacToe.Tile getStartingPlayer()
    {
        return start_symbol_;
    }

    GAME_MODE getGameMode() {
        return game_mode_;
    }

    AI_Difficulty getAiDifficulty() {
        return ai_difficulty_;
    }
}

