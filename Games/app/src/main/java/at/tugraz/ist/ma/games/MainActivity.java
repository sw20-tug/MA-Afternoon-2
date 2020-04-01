package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnTicTacToe = findViewById(R.id.btnTicTacToe);
        ImageButton btnDontTouch = findViewById(R.id.btnDontTouch);
        ImageButton btnSettings = findViewById(R.id.btnSettings);
        ImageButton btnHangman = findViewById(R.id.btnHangman);

        btnTicTacToe.setOnClickListener(v -> btnTicTacToe_Click());
        btnHangman.setOnClickListener(v -> btnHangman_Click());
        btnSettings.setOnClickListener(v -> btnSettings_Click());
        btnDontTouch.setOnClickListener(v -> btnDontTouch_Click());
    }

    private void btnTicTacToe_Click() {
        Intent intentTTTSettings = new Intent(getApplicationContext(), TicTacToeSettingsActivity.class);
        startActivity(intentTTTSettings);
    }

    private void btnHangman_Click() {

    }

    private void btnSettings_Click() {

    }

    private void btnDontTouch_Click() {

    }

}
