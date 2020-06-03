package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class HangmanWordActivity extends AppCompatActivity {

    private final HangmanWord hmw = new HangmanWord();

    ListView sett_list_words;
    int selectedIdx = -1;
    EditText sett_hangmanWord;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman_word);

        sett_list_words = findViewById(R.id.sett_list_words);

        hmw.loadWords();

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, hmw.getValues());

        sett_list_words.setAdapter(adapter);

        sett_list_words.setOnItemClickListener((parent, view, position, id) -> {
            if (sett_list_words.getSelector().getAlpha() == 0) {
                sett_list_words.getSelector().setAlpha(255);
            }
            selectedIdx = position;
        });


        Button btnAddWord = findViewById(R.id.sett_btn_add);
        Button btnDelWord= findViewById(R.id.sett_btn_delete);
        sett_hangmanWord = findViewById(R.id.sett_hangmanWord);

        btnAddWord.setOnClickListener(v -> btnAddWord_Click());
        btnDelWord.setOnClickListener(v -> btnDelWord_Click());
    }

    private void btnAddWord_Click() {
        String word = sett_hangmanWord.getText().toString();

        if(!word.isEmpty()) {
            if(!hmw.doesWordExist(word)) {
                hmw.addWord(word);
                sett_hangmanWord.setText("");
                hmw.saveWords();           }
            else {
                Toast toast=Toast.makeText(getApplicationContext(),R.string.sett_wordalready,Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        else {
            Toast toast=Toast.makeText(getApplicationContext(),R.string.sett_wordempty,Toast.LENGTH_SHORT);
            toast.show();
        }
        adapter.notifyDataSetChanged();
    }

    private void btnDelWord_Click() {
        if(selectedIdx != -1) {
            hmw.removeWord(selectedIdx);
            selectedIdx = -1;
            sett_list_words.clearChoices();
            sett_list_words.clearFocus();
            adapter.notifyDataSetChanged();
            sett_list_words.invalidateViews();
            sett_list_words.getSelector().setAlpha(0);

            hmw.saveWords();
        }
    }


}
