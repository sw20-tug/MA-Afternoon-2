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
        Random random = new Random();
        int rnd = random.nextInt(buttons.size());
        if(!debug_mode)
        {
            buttons.get(rnd).setBackgroundColor(Color.WHITE);
        }
        button_state.set(rnd,TileColor.WHITE);
        for(int i = 0; i < buttons.size(); i++)
        {
            if(i != rnd)
            {
                if(!debug_mode)
                {
                    buttons.get(i).setBackgroundColor(Color.BLACK);
                }
                button_state.set(i,TileColor.BLACK);
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
        changeField();
        return true;
    }
    public void restartGame()
    {
        player_points = 0;
        changeField();
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
