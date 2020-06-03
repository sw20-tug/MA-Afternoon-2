package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView tvMainPoints = findViewById(R.id.tvMainPoints);
        //tvMainPoints.setText(getString(R.string.main_yourpoints, ScoreHandler.getInstance().getScore()));

        ImageButton btnMainTicTacToe = findViewById(R.id.btnMainTicTacToe);
        ImageButton btnMainWhiteTiles = findViewById(R.id.btnMainWhiteTiles);
        ImageButton btnMainSettings = findViewById(R.id.btnMainSettings);
        ImageButton btnMainHangman = findViewById(R.id.btnMainHangman);

        btnMainTicTacToe.setOnClickListener(v -> btnMainTicTacToe_Click());
        btnMainHangman.setOnClickListener(v -> btnMainHangman_Click());
        btnMainSettings.setOnClickListener(v -> btnMainSettings_Click());
        btnMainWhiteTiles.setOnClickListener(v -> btnMainDontTouch_Click());
    }

    @Override
    public void onResume()
    {
        super.onResume();
        TextView tvMainPoints = findViewById(R.id.tvMainPoints);
        tvMainPoints.setText(getString(R.string.main_yourpoints, ScoreHandler.getInstance().getScore()));
    }


    private void btnMainTicTacToe_Click() {
        Intent intentTTT = new Intent(getApplicationContext(), TicTacToeSettingsActivity.class);
        startActivity(intentTTT);
    }

    private void btnMainHangman_Click() {
        Intent intentHM = new Intent(getApplicationContext(), HangmanActivity.class);
        startActivity(intentHM);
    }

    private void btnMainSettings_Click() {
        //Intent intentWT = new Intent(getApplicationContext(), SettingsActivity.class);
        //startActivity(intentWT);
    }

    private void btnMainDontTouch_Click() {
        Intent intentSET = new Intent(getApplicationContext(), WhiteTilesActivity.class);
        startActivity(intentSET);
    }

}
