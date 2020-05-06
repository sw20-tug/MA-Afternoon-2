package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.ToggleButton;

import com.google.gson.Gson;

public class TicTacToeSettingsActivity extends AppCompatActivity {

    int LAUNCH_TIC_TAC_TOE_GAME = 1;

    private TicTacToeSettings ttt_settings_ = new TicTacToeSettings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_settings);
        configBoardButtons();
    }

    public void configBoardButtons(){

        ToggleButton game_mode_tb       = findViewById(R.id.ttt_tb_GameMode);
        TableRow     player_two_table_row = findViewById(R.id.ttt_tr_PlayerTwoSymbolRow);
        ToggleButton player_one_symbol_tb = findViewById(R.id.ttt_tb_PlayerOneSymbol);
        ToggleButton player_two_symbol_tb = findViewById(R.id.ttt_tb_PlayerTwoSymbol);
        SeekBar ai_difficulty_sb        = findViewById(R.id.ttt_sb_AIDifficulty);

        Button play_btn = findViewById(R.id.ttt_btn_play);

        if(game_mode_tb.isChecked())
        {
            player_two_table_row.setVisibility(View.INVISIBLE);
        } else
        {
            player_two_table_row.setVisibility(View.VISIBLE);
        }

        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGameStart();
            }
        });

        game_mode_tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ttt_settings_.setGameMode(TicTacToeSettings.GAME_MODE.PVE);
                    player_two_table_row.setVisibility(View.INVISIBLE);
                } else {
                    ttt_settings_.setGameMode(TicTacToeSettings.GAME_MODE.PVP);
                    player_two_table_row.setVisibility(View.VISIBLE);
                }
            }
        });

        player_one_symbol_tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ttt_settings_.setStartingPlayer(TicTacToe.Tile.CIRCLE);
                    if(!player_two_symbol_tb.isChecked())
                        player_two_symbol_tb.setChecked(true);
                } else {
                    ttt_settings_.setStartingPlayer(TicTacToe.Tile.CROSS);
                    if(player_two_symbol_tb.isChecked())
                        player_two_symbol_tb.setChecked(false);
                }
            }
        });

        player_two_symbol_tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ttt_settings_.setStartingPlayer(TicTacToe.Tile.CIRCLE);
                    if(!player_one_symbol_tb.isChecked())
                        player_one_symbol_tb.setChecked(true);
                } else {
                    ttt_settings_.setStartingPlayer(TicTacToe.Tile.CROSS);
                    if(player_one_symbol_tb.isChecked())
                        player_one_symbol_tb.setChecked(false);
                }
            }
        });
    }

    public void handleGameStart()
    {

        Intent intent = new Intent(this, TicTacToeActivity.class);
        String transfer_ttt_settings_str = settingsToJsonString();
        intent.putExtra(getString(R.string.TTT_Transfer_Settings), transfer_ttt_settings_str);
        startActivityForResult(intent, LAUNCH_TIC_TAC_TOE_GAME);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_TIC_TAC_TOE_GAME) {
            if(resultCode == Activity.RESULT_OK || resultCode ==  Activity.RESULT_CANCELED){
                finish();
            }
            finish();
        }
    }

    public String settingsToJsonString()
    {
        Gson gson = new Gson();
        return gson.toJson(ttt_settings_);
    }
}
