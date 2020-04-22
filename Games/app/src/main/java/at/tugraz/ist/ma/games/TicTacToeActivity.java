package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener {

    private TicTacToe ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        ticTacToe = new TicTacToe();
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
            if(ticTacToe.checkWinActivePlayer()){
                Toast toast=Toast.makeText(getApplicationContext(),"Won Game",Toast.LENGTH_SHORT);
                toast.show();
                return;
            }

            ticTacToe.changePlayer();
            Toast toast=Toast.makeText(getApplicationContext(),"Player Changed",Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Toast toast=Toast.makeText(getApplicationContext(),"Field occupied",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
