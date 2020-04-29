package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnMainTicTacToe = findViewById(R.id.btnMainTicTacToe);
        ImageButton btnMainWhiteTiles = findViewById(R.id.btnMainWhiteTiles);
        ImageButton btnMainSettings = findViewById(R.id.btnMainSettings);
        ImageButton btnMainHangman = findViewById(R.id.btnMainHangman);

        btnMainTicTacToe.setOnClickListener(v -> btnMainTicTacToe_Click());
        btnMainHangman.setOnClickListener(v -> btnMainHangman_Click());
        btnMainSettings.setOnClickListener(v -> btnMainSettings_Click());
        btnMainWhiteTiles.setOnClickListener(v -> btnMainDontTouch_Click());
    }

    private void btnMainTicTacToe_Click() {
        Intent intentTTT = new Intent(getApplicationContext(), TicTacToeActivity.class);
        startActivity(intentTTT);
    }

    private void btnMainHangman_Click() {
        Intent intentHM = new Intent(getApplicationContext(), HangmanActivity.class);
        startActivity(intentHM);
    }

    private void btnMainSettings_Click() {
        //TODO un-comment next lines when White Tiles Activity becomes available
        //Intent intentWT = new Intent(getApplicationContext(), WhiteTilesSettingsActivity.class);
        //startActivity(intentWT);
    }

    private void btnMainDontTouch_Click() {
        //TODO un-comment next lines when Settings Activity becomes available
        //Intent intentSET = new Intent(getApplicationContext(), SettingsActivity.class);
        //startActivity(intentSET);
    }

}
