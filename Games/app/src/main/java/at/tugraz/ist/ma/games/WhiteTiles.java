package at.tugraz.ist.ma.games;

import java.util.ArrayList;
import java.util.Random;

import android.widget.Button;

public class WhiteTiles
{
    final static int WHITE_TILES_SCORE_INCREASE_CORRECT_TILE  =  1;
    final static int WHITE_TILES_SCORE_DEDUCTION_PER_LOSS     = -2;

    public enum TileColor {
        BLACK,
        WHITE
    }

    ArrayList<Button> buttons = new ArrayList<Button>();
    ArrayList<TileColor> button_state = new ArrayList<TileColor>();
    private int number_of_black_tiles = 4;
    private int player_points = 0;
    private boolean is_running = true;


    public WhiteTiles()
    {

    }

    public void changeField()
    {
        ArrayList<Integer> button_list = new ArrayList<Integer>();
        int counter = 0;

        // Fill an array with "number_of_black_tiles" different integers
        while (counter < number_of_black_tiles)
        {
            Random random = new Random();
            int rnd = random.nextInt(buttons.size());
            if (!button_list.contains(rnd))
            {
                button_list.add(rnd);
                counter++;
            }
        }

        for (int i = 0; i < buttons.size(); i++)
        {
            if (button_list.contains(i))
            {
                button_state.set(i, TileColor.BLACK);
            }
            else
            {
                button_state.set(i, TileColor.WHITE);
            }

        }
    }

    public void addBtnToList(Button btn)
    {
        buttons.add(btn);
        button_state.add(TileColor.WHITE);
    }

    public boolean checkCorrectTileAndCount(Button btn)
    {
        if(button_state.get(buttons.indexOf(btn)).equals(TileColor.WHITE))
        {
            setIs_running(false);
            return false;
        }
        player_points++;
        return true;
    }
    public void setPlayerPointsToZero()
    {
        player_points = 0;
    }

    public int getPlayer_points()
    {
        return player_points;
    }
    public void setIs_running(boolean running)
    {
        is_running = running;
    }
    public boolean getIs_running()
    {
        return is_running;
    }
    public ArrayList<TileColor> getButton_state()
    {
        return button_state;
    }
    public ArrayList<Button> getButtons()
    {
        return buttons;
    }

    public int getNumberOfBlackTiles()
    {
        return number_of_black_tiles;
    }
}
