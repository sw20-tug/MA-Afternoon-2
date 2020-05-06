package at.tugraz.ist.ma.games;

public class TicTacToeWinStrategy {
    private boolean isWin;
    private int[] fields = new int[3];

    public TicTacToeWinStrategy(int a, int b, int c){
        isWin = true;
        fields[0] = a;
        fields[1] = b;
        fields[2] = c;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isWin() {
        return isWin;
    }

    public int[] getFields() {
        return fields;
    }
}
