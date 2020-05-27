package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HangmanWordActivity extends AppCompatActivity {

    ListView sett_list_words;
    String selectedWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_word);

        sett_list_words = findViewById(R.id.sett_list_words);

        String[] values = new String[] {
                "Word 1",
                "Word 2",
                "Word 3",
                "Word 4",
                "Word 5",
                "Word 6",
                "Word 7",
                "Word 8",
                "Word 9",
                "Word 10",
                "Word 11",
                "Word 12",
                "Word 13",
                "Word 14",
                "Word 15",
                "Word 16",
                "Word 17"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        sett_list_words.setAdapter(adapter);

        sett_list_words.setOnItemClickListener((parent, view, position, id) -> {
            selectedWord = (String)sett_list_words.getItemAtPosition(position);
        });


    }
}
