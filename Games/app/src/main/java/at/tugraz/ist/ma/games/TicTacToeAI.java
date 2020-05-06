package at.tugraz.ist.ma.games;

import java.util.Arrays;

class TicTacToeAI {
    private TicTacToe.Tile[] board_;
    private TicTacToeWinStrategy[] winStrategies_ = new TicTacToeWinStrategy[8];
    private TicTacToe.Tile aiTile_;

    TicTacToeAI(TicTacToe.Tile aiTile){
        aiTile_ = aiTile;
        board_ = new TicTacToe.Tile[9];
        Arrays.fill(board_, TicTacToe.Tile.NONE);

        winStrategies_[0] = new TicTacToeWinStrategy(0,1,2);
        winStrategies_[1] = new TicTacToeWinStrategy(3,4,5);
        winStrategies_[2] = new TicTacToeWinStrategy(6,7,8);
        winStrategies_[3] = new TicTacToeWinStrategy(0,3,6);
        winStrategies_[4] = new TicTacToeWinStrategy(1,4,7);
        winStrategies_[5] = new TicTacToeWinStrategy(2,5,8);
        winStrategies_[6] = new TicTacToeWinStrategy(0,4,8);
        winStrategies_[7] = new TicTacToeWinStrategy(2,4,6);
    }

    void setTile(int row, int col, TicTacToe.Tile player){


    }
//
//    int getMoveAIRow(){
//
//    }
//    int getMoveAICol(){
//
//    }

    private int boardIndexFromRowCol(int row, int col){
        return 3*row+col;
    }
}
