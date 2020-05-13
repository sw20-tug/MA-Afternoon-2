package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WhiteTilesActivity extends AppCompatActivity {

    WhiteTiles whiteTiles = new WhiteTiles();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_tiles);

        Button btn_1_1 = (Button) findViewById(R.id.btnWhiteTilesGameButton1_1);
        whiteTiles.addBtnToList(btn_1_1);

        Button btn_1_2 = (Button) findViewById(R.id.btnWhiteTilesGameButton1_2);
        whiteTiles.addBtnToList(btn_1_2);

        Button btn_1_3 = (Button) findViewById(R.id.btnWhiteTilesGameButton1_3);
        whiteTiles.addBtnToList(btn_1_3);

        Button btn_1_4 = (Button) findViewById(R.id.btnWhiteTilesGameButton1_4);
        whiteTiles.addBtnToList(btn_1_4);

        Button btn_2_1 = (Button) findViewById(R.id.btnWhiteTilesGameButton2_1);
        whiteTiles.addBtnToList(btn_2_1);

        Button btn_2_2 = (Button) findViewById(R.id.btnWhiteTilesGameButton2_2);
        whiteTiles.addBtnToList(btn_2_2);

        Button btn_2_3 = (Button) findViewById(R.id.btnWhiteTilesGameButton2_3);
        whiteTiles.addBtnToList(btn_2_3);

        Button btn_2_4 = (Button) findViewById(R.id.btnWhiteTilesGameButton2_4);
        whiteTiles.addBtnToList(btn_2_4);

        Button btn_3_1 = (Button) findViewById(R.id.btnWhiteTilesGameButton3_1);
        whiteTiles.addBtnToList(btn_3_1);

        Button btn_3_2 = (Button) findViewById(R.id.btnWhiteTilesGameButton3_2);
        whiteTiles.addBtnToList(btn_3_2);

        Button btn_3_3 = (Button) findViewById(R.id.btnWhiteTilesGameButton3_3);
        whiteTiles.addBtnToList(btn_3_3);

        Button btn_3_4 = (Button) findViewById(R.id.btnWhiteTilesGameButton3_4);
        whiteTiles.addBtnToList(btn_3_4);

        Button btn_4_1 = (Button) findViewById(R.id.btnWhiteTilesGameButton4_1);
        whiteTiles.addBtnToList(btn_4_1);

        Button btn_4_2 = (Button) findViewById(R.id.btnWhiteTilesGameButton4_2);
        whiteTiles.addBtnToList(btn_4_2);

        Button btn_4_3 = (Button) findViewById(R.id.btnWhiteTilesGameButton4_3);
        whiteTiles.addBtnToList(btn_4_3);

        Button btn_4_4 = (Button) findViewById(R.id.btnWhiteTilesGameButton4_4);
        whiteTiles.addBtnToList(btn_4_4);


        btn_1_1.setOnClickListener(v -> btnWhiteTileClick(btn_1_1));
        btn_1_2.setOnClickListener(v -> btnWhiteTileClick(btn_1_2));
        btn_1_3.setOnClickListener(v -> btnWhiteTileClick(btn_1_3));
        btn_1_4.setOnClickListener(v -> btnWhiteTileClick(btn_1_4));

        btn_2_1.setOnClickListener(v -> btnWhiteTileClick(btn_2_1));
        btn_2_2.setOnClickListener(v -> btnWhiteTileClick(btn_2_2));
        btn_2_3.setOnClickListener(v -> btnWhiteTileClick(btn_2_3));
        btn_2_4.setOnClickListener(v -> btnWhiteTileClick(btn_2_4));

        btn_3_1.setOnClickListener(v -> btnWhiteTileClick(btn_3_1));
        btn_3_2.setOnClickListener(v -> btnWhiteTileClick(btn_3_2));
        btn_3_3.setOnClickListener(v -> btnWhiteTileClick(btn_3_3));
        btn_3_4.setOnClickListener(v -> btnWhiteTileClick(btn_3_4));

        btn_4_1.setOnClickListener(v -> btnWhiteTileClick(btn_4_1));
        btn_4_2.setOnClickListener(v -> btnWhiteTileClick(btn_4_2));
        btn_4_3.setOnClickListener(v -> btnWhiteTileClick(btn_4_3));
        btn_4_4.setOnClickListener(v -> btnWhiteTileClick(btn_4_4));


        Button restart_btn = (Button) findViewById(R.id.btnWhiteTilesRestart);
        restart_btn.setOnClickListener(v -> restartGameButtonClick());

        whiteTiles.changeField();
        changeUIButtonColor();
    }


    private void btnWhiteTileClick(Button btn)
    {
        if(!whiteTiles.getIs_running())
        {
            return;
        }
        if(!whiteTiles.checkCorrectTileAndCount(btn))
        {
            Toast.makeText(this, "You lost", Toast.LENGTH_LONG).show();
        }
        else
        {
            whiteTiles.changeField();
            changeUIButtonColor();
            TextView score = (TextView) findViewById(R.id.tvWhiteTilesYourPoints);
            String str = getString(R.string.WhiteTilesYourPoints)+ String.valueOf(whiteTiles.getPlayer_points());
            score.setText(str);
        }

    }

    private void restartGameButtonClick()
    {
        whiteTiles.setPlayerPointsToZero();
        whiteTiles.changeField();
        changeUIButtonColor();
        whiteTiles.setIs_running(true);
        TextView score = (TextView) findViewById(R.id.tvWhiteTilesYourPoints);
        String str = getString(R.string.WhiteTilesYour0Points);
        score.setText(str);
    }



    private void changeUIButtonColor()
    {
        ArrayList<WhiteTiles.TileColor> button_state = whiteTiles.getButton_state();

        for(int i = 0; i < button_state.size();i++)
        {
            if(i >= whiteTiles.getButtons().size())
            {
                return;
            }
            if(button_state.get(i).equals(WhiteTiles.TileColor.WHITE))
            {
                whiteTiles.getButtons().get(i).setBackgroundColor(Color.WHITE);
            }
            else
            {
                whiteTiles.getButtons().get(i).setBackgroundColor(Color.BLACK);
            }
        }
    }
}

