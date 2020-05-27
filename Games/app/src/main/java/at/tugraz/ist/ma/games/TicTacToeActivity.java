package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;


public class TicTacToeActivity extends AppCompatActivity implements View.OnClickListener
{
    private TicTacToe ticTacToe;
    private TicTacToeSettings ticTacToeSettings;
    private TicTacToeAI ai;
    private Button[][] buttonBoard;
    private TicTacToe.Tile player_symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        readSettings();
        createGame();
    }

    public void readSettings()
    {
        String jsonString = getIntent().getStringExtra(getString(R.string.TTT_Transfer_Settings));
        ticTacToeSettings = tttSettingsFromJsonString(jsonString);
    }

    public void createGame()
    {
        setContentView(R.layout.activity_tic_tac_toe);
        configBoardButtons();
        if(ticTacToeSettings == null)
            ticTacToeSettings = new TicTacToeSettings();
        ticTacToe = new TicTacToe(ticTacToeSettings.getStartingPlayer());
        player_symbol = ticTacToeSettings.getStartingPlayer();
        setPlayerText();
        TextView gameModeTv = findViewById(R.id.ttt_tv_game_mode);
        gameModeTv.setText(getString(R.string.GameModePvP));

        if(ticTacToeSettings.getGameMode() == TicTacToeSettings.GAME_MODE.PVE){
            gameModeTv.setText(getString(R.string.GameModePvAI));
            if(player_symbol == TicTacToe.Tile.CROSS){
                ai = new TicTacToeAI(TicTacToe.Tile.CIRCLE);
            } else {
                ai = new TicTacToeAI(TicTacToe.Tile.CROSS);
            }
        }
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

        buttonBoard = new Button[3][3];
        buttonBoard[0][0] = btn_0_0;
        buttonBoard[0][1] = btn_0_1;
        buttonBoard[0][2] = btn_0_2;
        buttonBoard[1][0] = btn_1_0;
        buttonBoard[1][1] = btn_1_1;
        buttonBoard[1][2] = btn_1_2;
        buttonBoard[2][0] = btn_2_0;
        buttonBoard[2][1] = btn_2_1;
        buttonBoard[2][2] = btn_2_2;

        Button btn_play_again = findViewById(R.id.btn_play_again);

        btn_play_again.setOnClickListener(v -> createGame());


    }

    @Override
    public void onClick(View v) {
        int row = -1;
        int col = -1;

        switch(v.getId()){
            case R.id.btn_field_0_0:
                row = 0;
                col = 0;
                break;
            case R.id.btn_field_0_1:
                row = 0;
                col = 1;
                break;
            case R.id.btn_field_0_2:
                row = 0;
                col = 2;
                break;
            case R.id.btn_field_1_0:
                row = 1;
                col = 0;
                break;
            case R.id.btn_field_1_1:
                row = 1;
                col = 1;
                break;
            case R.id.btn_field_1_2:
                row = 1;
                col = 2;
                break;
            case R.id.btn_field_2_0:
                row = 2;
                col = 0;
                break;
            case R.id.btn_field_2_1:
                row = 2;
                col = 1;
                break;
            case R.id.btn_field_2_2:
                row = 2;
                col = 2;
                break;
        }

        boolean validMove = setTile(row, col);

        if(validMove && ticTacToeSettings.getGameMode() == TicTacToeSettings.GAME_MODE.PVE){
            ai.setTilePlayer(row, col);
            int aiIndex = ai.doAIMove();
            row = ai.getRow(aiIndex);
            col = ai.getCol(aiIndex);
            setTile(row, col);
        }
    }

    public void setTileInView(int row, int col) {
        Button button = buttonBoard[row][col];
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

    private boolean setTile(int row, int col){
        boolean isSetTile = ticTacToe.setTileActivePlayer(row, col);


        if(isSetTile){
            setTileInView(row, col);
            if(ticTacToe.checkWinActivePlayer())
            {
                disableField();
                if(ticTacToeSettings.getStartingPlayer() == ticTacToe.getActivePlayer())
                {
                    ScoreHandler.getInstance().addPointsToScore(TicTacToe.TTT_SCORE_INCREASE_PER_WIN);
                } else
                {
                    ScoreHandler.getInstance().addPointsToScore(TicTacToe.TTT_SCORE_DEDUCTION_PER_LOSS);
                }

                Toast toast=Toast.makeText(getApplicationContext(),"Won Game " + ticTacToe.getPlayerName(),Toast.LENGTH_SHORT);
                toast.show();

                return false;
            }
            if(ticTacToe.checkTie())
            {
                Toast toast=Toast.makeText(getApplicationContext(),"It's a tie!",Toast.LENGTH_SHORT);
                toast.show();
                disableField();
                return false;
            }

            ticTacToe.changePlayer();
            setPlayerText();

        } else {
            Toast toast=Toast.makeText(getApplicationContext(),"Field occupied",Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        return true;
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

    public TicTacToeSettings tttSettingsFromJsonString(String jsonString)
    {
        Gson gson = new Gson();
        Type ttt_settings = new TypeToken<TicTacToeSettings>() {
        }.getType();

        return gson.fromJson(jsonString, ttt_settings);
    }
}
