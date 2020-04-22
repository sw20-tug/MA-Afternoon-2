package at.tugraz.ist.ma.games;

import java.util.ArrayList;

public class TicTacToe {
    enum Tile {
        NONE,
        CROSS,
        CIRCLE
    }

    private Tile[][] board_;
    private Tile active_player;

    public TicTacToe(){
        board_ = new Tile[3][3];
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board_[row][col] = Tile.NONE;
            }
        }
        active_player = Tile.CROSS;
    }

    public boolean setTileActivePlayer(Integer row, Integer col) throws IndexOutOfBoundsException{
        return setTile(row, col, active_player);
    }

    public boolean setTile(Integer row, Integer col, Tile tile) throws IndexOutOfBoundsException {
        if(board_[row][col] != Tile.NONE){
            return false;
        }
        board_[row][col] = tile;
        return true;
    }

    public Tile[][] getBoard(){
        return board_;
    }

    public boolean checkWinActivePlayer(){
        return checkWin(active_player);
    }

    public boolean checkWin(Tile last_tile){

        //column check
        int i = 0;
        for(int row = 0; row < 3; row++){
            while (board_[row][i] == last_tile) {
                if (i == 2) {
                    return true;
                }
                i++;
            }
        }

        //row check
        i = 0;
        for(int col = 0; col < 3; col++){
            while (board_[i][col] == last_tile) {
                if (i == 2) {
                    return true;
                }
                i++;
            }
        }

        return board_[0][0] == last_tile && board_[1][1] == last_tile && board_[2][2] == last_tile ||
                board_[2][0] == last_tile && board_[1][1] == last_tile && board_[0][2] == last_tile;
    }

    public void changePlayer(){
        active_player = active_player == Tile.CROSS ? Tile.CIRCLE : Tile.CROSS;
    }
}
