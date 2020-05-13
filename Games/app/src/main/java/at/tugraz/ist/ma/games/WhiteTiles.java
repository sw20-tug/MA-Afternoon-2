package at.tugraz.ist.ma.games;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;




public class WhiteTiles
{
    public enum TileColor {
        BLACK,
        WHITE
    }
    ArrayList<Button> buttons = new ArrayList<Button>();
    ArrayList<TileColor> button_state = new ArrayList<TileColor>();
    private int number_of_black_tiles = 4;
    private int player_points = 0;
    private boolean debug_mode = false;
    private boolean is_running = true;

    public WhiteTiles(boolean debug_mode)
    {
        this.debug_mode = debug_mode;

    }
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
            //If the button number is present in our randomly generated list, it becomes a black button
            if (button_list.contains(i))
            {
                button_state.set(i, TileColor.BLACK);
                if(!debug_mode)
                {
                    buttons.get(i).setBackgroundColor(Color.BLACK);
                }
            }

            //else it becomes white
            else {
                button_state.set(i, TileColor.WHITE);
                if(!debug_mode)
                {
                    buttons.get(i).setBackgroundColor(Color.WHITE);
                }
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

}
