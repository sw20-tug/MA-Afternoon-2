package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnEditWords = findViewById(R.id.sett_btn_editwords);
        Button btnAbout= findViewById(R.id.sett_btn_about);

        btnEditWords.setOnClickListener(v -> btnEditWords_Click());
        btnAbout.setOnClickListener(v -> btnAbout_Click());
    }

    private void btnEditWords_Click() {
        Intent intentTTT = new Intent(getApplicationContext(), HangmanWordActivity.class);
        startActivity(intentTTT);
    }

    private void btnAbout_Click() {
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("di Vora Stefan\n" +
                "Herzl Marco\n" +
                "Kargl Matthias\n" +
                "Pollhammer Daniel\n" +
                "Reiterer Alexander\n" +
                "Suntinger-Schrampf Jürgen");
        dlgAlert.setTitle(R.string.title);
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);

        dlgAlert.setPositiveButton("Ok",
                (dialog, which) -> {
                    //dismiss
                });

        dlgAlert.create().show();

    }
}
