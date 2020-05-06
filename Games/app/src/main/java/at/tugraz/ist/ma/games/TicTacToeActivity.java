package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {

    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createGame();
    }

    public void createGame()
    {
        setContentView(R.layout.activity_tic_tac_toe);
        configBoardButtons();
        ticTacToe = new TicTacToe();
        setPlayerText();
    }

    public void setPlayerText() {
        TextView tv_status = findViewById(R.id.tvStatus);
        if (ticTacToe != null)
        {
            switch (ticTacToe.getActivePlayer())
            {
                case CROSS:
                    tv_status.setText(R.string.player_cross);
                    break;
                case CIRCLE:
                    tv_status.setText(R.string.player_circle);
                    break;
                case NONE:
                default:
                    tv_status.setText("");
            }
        }
    }
    public void configBoardButtons(){

        Button btn_0_0 = findViewById(R.id.btn_field_0_0);
        Button btn_0_1 = findViewById(R.id.btn_field_0_1);
        Button btn_0_2 = findViewById(R.id.btn_field_0_2);
        Button btn_1_0 = findViewById(R.id.btn_field_1_0);
        Button btn_1_1 = findViewById(R.id.btn_field_1_1);
        Button btn_1_2 = findViewById(R.id.btn_field_1_2);
        Button btn_2_0 = findViewById(R.id.btn_field_2_0);
        Button btn_2_1 = findViewById(R.id.btn_field_2_1);
        Button btn_2_2 = findViewById(R.id.btn_field_2_2);

        btn_0_0.setOnClickListener(this);
        btn_0_1.setOnClickListener(this);
        btn_0_2.setOnClickListener(this);
        btn_1_0.setOnClickListener(this);
        btn_1_1.setOnClickListener(this);
        btn_1_2.setOnClickListener(this);
        btn_2_0.setOnClickListener(this);
        btn_2_1.setOnClickListener(this);
        btn_2_2.setOnClickListener(this);


        Button btn_play_again = findViewById(R.id.btn_play_again);

        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createGame();
            }
        });


    }

    @Override
    public void onClick(View v) {
        boolean isSetTile = false;

        switch(v.getId()){
            case R.id.btn_field_0_0:
                isSetTile = ticTacToe.setTileActivePlayer(0,0);
                break;
            case R.id.btn_field_0_1:
                isSetTile = ticTacToe.setTileActivePlayer(0,1);
                break;
            case R.id.btn_field_0_2:
                isSetTile = ticTacToe.setTileActivePlayer(0,2);
                break;
            case R.id.btn_field_1_0:
                isSetTile = ticTacToe.setTileActivePlayer(1,0);
                break;
            case R.id.btn_field_1_1:
                isSetTile = ticTacToe.setTileActivePlayer(1,1);
                break;
            case R.id.btn_field_1_2:
                isSetTile = ticTacToe.setTileActivePlayer(1,2);
                break;
            case R.id.btn_field_2_0:
                isSetTile = ticTacToe.setTileActivePlayer(2,0);
                break;
            case R.id.btn_field_2_1:
                isSetTile = ticTacToe.setTileActivePlayer(2,1);
                break;
            case R.id.btn_field_2_2:
                isSetTile = ticTacToe.setTileActivePlayer(2,2);
                break;
        }


        if(isSetTile){
            setTileInView(v);
            if(ticTacToe.checkWinActivePlayer()){
                disableField();
                Toast toast=Toast.makeText(getApplicationContext(),"Won Game " + ticTacToe.getPlayerName(),Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if(ticTacToe.checkTie())
            {
                Toast toast=Toast.makeText(getApplicationContext(),"It's a tie!",Toast.LENGTH_SHORT);
                toast.show();
                disableField();
                return;
            }

            ticTacToe.changePlayer();
            setPlayerText();

        } else {
            Toast toast=Toast.makeText(getApplicationContext(),"Field occupied",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void setTileInView(View view) {
        Button button = (Button)view;
        switch (ticTacToe.getActivePlayer())
        {
            case CROSS:
                button.setBackgroundResource(R.drawable.ic_ttt_cross);
                button.setTag(getString(R.string.player_cross));
                break;
            case CIRCLE:
                button.setBackgroundResource(R.drawable.ic_ttt_circle);
                button.setTag(getString(R.string.player_circle));
                break;
            case NONE:
            default:
                button.setBackgroundResource(0);
                button.setTag(getString(R.string.player_none));
                break;
        }
    }

    public void disableField()
    {
        Button btn_0_0 = findViewById(R.id.btn_field_0_0);
        Button btn_0_1 = findViewById(R.id.btn_field_0_1);
        Button btn_0_2 = findViewById(R.id.btn_field_0_2);
        Button btn_1_0 = findViewById(R.id.btn_field_1_0);
        Button btn_1_1 = findViewById(R.id.btn_field_1_1);
        Button btn_1_2 = findViewById(R.id.btn_field_1_2);
        Button btn_2_0 = findViewById(R.id.btn_field_2_0);
        Button btn_2_1 = findViewById(R.id.btn_field_2_1);
        Button btn_2_2 = findViewById(R.id.btn_field_2_2);

        btn_0_0.setClickable(false);
        btn_0_1.setClickable(false);
        btn_0_2.setClickable(false);
        btn_1_0.setClickable(false);
        btn_1_1.setClickable(false);
        btn_1_2.setClickable(false);
        btn_2_0.setClickable(false);
        btn_2_1.setClickable(false);
        btn_2_2.setClickable(false);

    }
}
