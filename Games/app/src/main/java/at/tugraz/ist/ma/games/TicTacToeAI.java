package at.tugraz.ist.ma.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

class TicTacToeAI {
    private TicTacToe.Tile[] board_;
    private TicTacToe.Tile aiTile_;
    private TicTacToe.Tile playerTile_ = TicTacToe.Tile.NONE;
    private Map<TicTacToe.Tile, TicTacToeWinStrategy[] > winStrategies = new HashMap<>();



    TicTacToeAI(TicTacToe.Tile aiTile){
        aiTile_ = aiTile;
        board_ = new TicTacToe.Tile[9];
        Arrays.fill(board_, TicTacToe.Tile.NONE);

        winStrategies.put(aiTile_, new TicTacToeWinStrategy[8]);
        Objects.requireNonNull(winStrategies.get(aiTile_))[0] =  new TicTacToeWinStrategy(0,1,2);
        Objects.requireNonNull(winStrategies.get(aiTile_))[1] =  new TicTacToeWinStrategy(3,4,5);
        Objects.requireNonNull(winStrategies.get(aiTile_))[2] =  new TicTacToeWinStrategy(6,7,8);
        Objects.requireNonNull(winStrategies.get(aiTile_))[3] =  new TicTacToeWinStrategy(0,3,6);
        Objects.requireNonNull(winStrategies.get(aiTile_))[4] =  new TicTacToeWinStrategy(1,4,7);
        Objects.requireNonNull(winStrategies.get(aiTile_))[5] =  new TicTacToeWinStrategy(2,5,8);
        Objects.requireNonNull(winStrategies.get(aiTile_))[6] =  new TicTacToeWinStrategy(0,4,8);
        Objects.requireNonNull(winStrategies.get(aiTile_))[7] =  new TicTacToeWinStrategy(2,4,6);

        playerTile_ = getOpositeTile(aiTile_);

        winStrategies.put(playerTile_, new TicTacToeWinStrategy[8]);
        Objects.requireNonNull(winStrategies.get(playerTile_))[0] =  new TicTacToeWinStrategy(0,1,2);
        Objects.requireNonNull(winStrategies.get(playerTile_))[1] =  new TicTacToeWinStrategy(3,4,5);
        Objects.requireNonNull(winStrategies.get(playerTile_))[2] =  new TicTacToeWinStrategy(6,7,8);
        Objects.requireNonNull(winStrategies.get(playerTile_))[3] =  new TicTacToeWinStrategy(0,3,6);
        Objects.requireNonNull(winStrategies.get(playerTile_))[4] =  new TicTacToeWinStrategy(1,4,7);
        Objects.requireNonNull(winStrategies.get(playerTile_))[5] =  new TicTacToeWinStrategy(2,5,8);
        Objects.requireNonNull(winStrategies.get(playerTile_))[6] =  new TicTacToeWinStrategy(0,4,8);
        Objects.requireNonNull(winStrategies.get(playerTile_))[7] =  new TicTacToeWinStrategy(2,4,6);
    }

    void setTileAiForTest(int row, int col){
        board_[boardIndexFromRowCol(row, col)] = aiTile_;
        deleteWinStrategies(boardIndexFromRowCol(row, col), playerTile_);
    }


    void setTilePlayer(int row, int col)
    {
        board_[boardIndexFromRowCol(row, col)] = playerTile_;
        deleteWinStrategies(boardIndexFromRowCol(row, col), aiTile_);
    }

    int doAIMove()
    {
        for (TicTacToeWinStrategy ws : Objects.requireNonNull(winStrategies.get(aiTile_))){
            if(ws.isWin()) {
                int numberPlayerSetFields = getNumberOfSetFields(ws, aiTile_);
                if(numberPlayerSetFields == 2){
                    int aiMove = getIndexRandFreeField(ws);
                    board_[aiMove] = aiTile_;
                    deleteWinStrategies(aiMove, playerTile_);
                    return aiMove;
                }
            }
        }

        for (TicTacToeWinStrategy ws : Objects.requireNonNull(winStrategies.get(playerTile_))){
            if(ws.isWin()) {
                int numberPlayerSetFields = getNumberOfSetFields(ws, playerTile_);
                if(numberPlayerSetFields == 2)
                {
                    int aiMove = getIndexRandFreeField(ws);
                    board_[aiMove] = aiTile_;
                    deleteWinStrategies(aiMove, playerTile_);
                    return aiMove;
                }
            }
        }

        List<Integer> possibleIndices = new ArrayList<>();

        for(int i = 0; i < Objects.requireNonNull(winStrategies.get(aiTile_)).length; i++){
            TicTacToeWinStrategy ws =  Objects.requireNonNull(winStrategies.get(aiTile_))[i];
            if(ws.isWin()) {
                int numberPlayerSetFields = getNumberOfSetFields(ws, aiTile_);
                if(numberPlayerSetFields == 1)
                {
                    possibleIndices.add(i);
                }
            }
        }

        if(!possibleIndices.isEmpty())
        {
            Random rand = new Random();
            int pi = possibleIndices.get(rand.nextInt(possibleIndices.size()));
            TicTacToeWinStrategy ws =  Objects.requireNonNull(winStrategies.get(aiTile_))[pi];
            int aiMove = getIndexRandFreeField(ws);
            board_[aiMove] = aiTile_;
            deleteWinStrategies(aiMove, playerTile_);
            return aiMove;
        }

        for(int i = 0; i < Objects.requireNonNull(winStrategies.get(playerTile_)).length; i++){
            TicTacToeWinStrategy ws =  Objects.requireNonNull(winStrategies.get(playerTile_))[i];
            if(ws.isWin()) {
                int numberPlayerSetFields = getNumberOfSetFields(ws, playerTile_);
                if(numberPlayerSetFields == 1)
                {
                    possibleIndices.add(i);
                }
            }
        }
        if(!possibleIndices.isEmpty())
        {
            Random rand = new Random();
            int pi = possibleIndices.get(rand.nextInt(possibleIndices.size()));
            TicTacToeWinStrategy ws =  Objects.requireNonNull(winStrategies.get(playerTile_))[pi];
            int aiMove = getIndexRandFreeField(ws);
            board_[aiMove] = aiTile_;
            deleteWinStrategies(aiMove, playerTile_);
            return aiMove;
        }

        return -1;
    }

    private void deleteWinStrategies(int index, TicTacToe.Tile playerTile){
        for (TicTacToeWinStrategy ws : Objects.requireNonNull(winStrategies.get(playerTile))){
            for (int i : ws.getFields()){
                if (i == index)
                {
                    ws.setWin(false);
                    break;
                }
            }
        }
    }

    private int getNumberOfSetFields (TicTacToeWinStrategy ws, TicTacToe.Tile tile)
    {
        int result = 0;
        for(int index : ws.getFields()){
            if(board_[index] == tile)
            {
                result++;
            }
        }
        return result;
    }

    private int getIndexRandFreeField (TicTacToeWinStrategy ws){
        List<Integer> freeFields = new ArrayList<>();

        for(int i : ws.getFields()){
            if(board_[i] == TicTacToe.Tile.NONE)
            {
                freeFields.add(i);
            }
        }

        Random rand = new Random();
        return freeFields.get(rand.nextInt(freeFields.size()));
    }


    TicTacToe.Tile getOpositeTile(TicTacToe.Tile tile){
        if(tile == TicTacToe.Tile.CROSS){
            return TicTacToe.Tile.CIRCLE;
        } else {
            return TicTacToe.Tile.CROSS;
        }
    }

    int getRow(int index){
        return index / 3;
    }

    int getCol(int index){
        return index % 3;
    }

    int boardIndexFromRowCol(int row, int col){
        return 3*row+col;
    }
}
