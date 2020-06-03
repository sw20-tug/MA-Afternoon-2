package at.tugraz.ist.ma.games;

class TicTacToe
{
    final static int TTT_SCORE_INCREASE_PER_WIN   =  1;
    final static int TTT_SCORE_DEDUCTION_PER_LOSS = -2;

    public enum Tile {
        NONE,
        CROSS,
        CIRCLE
    }

    private Tile[][] board_;
    private Tile active_player;
    private int game_move_count;

    TicTacToe(){
        board_ = new Tile[3][3];
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board_[row][col] = Tile.NONE;
            }
        }
        game_move_count = 0;
        active_player = Tile.CROSS;
    }

    TicTacToe(Tile player){
        board_ = new Tile[3][3];
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board_[row][col] = Tile.NONE;
            }
        }
        game_move_count = 0;
        active_player = player;
    }
  
    boolean setTileActivePlayer(Integer row, Integer col) throws IndexOutOfBoundsException{
        return setTile(row, col, active_player);
    }

    boolean setTile(Integer row, Integer col, Tile tile) throws IndexOutOfBoundsException {
        if(board_[row][col] != Tile.NONE){
            System.out.println("Field " + row + ", " + col + " is occupied");
            return false;
        }
        board_[row][col] = tile;
        game_move_count++;
        return true;
    }

    Tile[][] getBoard(){
        return board_;
    }

    Tile getActivePlayer() {
        return active_player;
    }

    boolean checkTie(){
        return game_move_count >= 9;
    }

    boolean checkWinActivePlayer(){
        return checkWin(active_player);
    }

    boolean checkWin(Tile last_tile)
    {
        for(int row = 0; row < 3; row++){
            int col = 0;
            while (board_[row][col] == last_tile) {
                if (col == 2) {
                    System.out.println(getPlayerName() + " Won Game");
                    return true;
                }
                col++;
            }
        }

        for(int col = 0; col < 3; col++){
            int row = 0;
            while (board_[row][col] == last_tile) {
                if (row == 2) {
                    System.out.println(getPlayerName() + " Won Game");
                    return true;
                }
                row++;
            }
        }

        boolean result = board_[0][0] == last_tile && board_[1][1] == last_tile && board_[2][2] == last_tile ||
                board_[2][0] == last_tile && board_[1][1] == last_tile && board_[0][2] == last_tile;

        if(result)
        {
            System.out.println(getPlayerName() + " Won Game");
        }
        return result;
    }

    void changePlayer(){
        active_player = active_player == Tile.CROSS ? Tile.CIRCLE : Tile.CROSS;
        System.out.println(" Player changed to " + getPlayerName());
    }

    String getPlayerName() {
        switch (active_player) {
            case CROSS:
                return "Cross";
            case CIRCLE:
                return "Circle";
            case NONE:
            default:
        }
        return "Undefined";
    }
}
