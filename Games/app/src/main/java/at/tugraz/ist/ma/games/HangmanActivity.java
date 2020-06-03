package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;


public class HangmanActivity extends AppCompatActivity {

    private Hangman hangman_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(getString(R.string.hm_default_words));
        } catch (JSONException e) {
            System.out.println("Cannot read default word (Invalid json)" + e.toString());
        }

        String[] default_word_list;
        if(jsonArray != null) {
            default_word_list = new String[jsonArray.length()];
        }
        else {
            default_word_list = new String[] {};
        }

        for(int i = 0; i < (jsonArray != null ? jsonArray.length() : 0); i++){
            default_word_list[i] = jsonArray.optString(i);
        }

        setContentView(R.layout.activity_hangman);
        String[] word_list;
        try {
            word_list = DataManager.loadWordList(getApplicationContext());
        } catch (Exception e) {
            System.out.println("Using default words");
            word_list = new String[]{};
        }

        ArrayList<String> wl_default = new ArrayList<>(Arrays.asList(default_word_list));
        ArrayList<String> wl_custom = new ArrayList<>(Arrays.asList(word_list));
        ArrayList<String> words = new ArrayList<>();
        words.addAll(wl_default);
        words.addAll(wl_custom);

        hangman_ = new Hangman(words.toArray(new String[0]));

        final TextView text = findViewById(R.id.guessableWord);
        text.setText(hangman_.getCurrentGuess());

        final Button buttonHangmanPlayAgain = findViewById(R.id.buttonHangmanPlayAgain);
        final TextView hangmanWinLoose = findViewById(R.id.hangmanWinLoose);
        buttonHangmanPlayAgain.setOnClickListener(v -> Replay(text,buttonHangmanPlayAgain,hangmanWinLoose));


        final Button buttonA = findViewById(R.id.buttonA);
        final Button buttonB = findViewById(R.id.buttonB);
        final Button buttonC = findViewById(R.id.buttonC);
        final Button buttonD = findViewById(R.id.buttonD);
        final Button buttonE = findViewById(R.id.buttonE);
        final Button buttonF = findViewById(R.id.buttonF);
        final Button buttonG = findViewById(R.id.buttonG);
        final Button buttonH = findViewById(R.id.buttonH);
        final Button buttonI = findViewById(R.id.buttonI);
        final Button buttonJ = findViewById(R.id.buttonJ);
        final Button buttonK = findViewById(R.id.buttonK);
        final Button buttonL = findViewById(R.id.buttonL);
        final Button buttonM = findViewById(R.id.buttonM);
        final Button buttonN = findViewById(R.id.buttonN);
        final Button buttonO = findViewById(R.id.buttonO);
        final Button buttonP = findViewById(R.id.buttonP);
        final Button buttonQ = findViewById(R.id.buttonQ);
        final Button buttonR = findViewById(R.id.buttonR);
        final Button buttonS = findViewById(R.id.buttonS);
        final Button buttonT = findViewById(R.id.buttonT);
        final Button buttonU = findViewById(R.id.buttonU);
        final Button buttonV = findViewById(R.id.buttonV);
        final Button buttonW = findViewById(R.id.buttonW);
        final Button buttonX = findViewById(R.id.buttonX);
        final Button buttonY = findViewById(R.id.buttonY);
        final Button buttonZ = findViewById(R.id.buttonZ);

        buttonA.setOnClickListener(v -> clickCharacter('a', buttonA, text));
        buttonB.setOnClickListener(v -> clickCharacter('b', buttonB, text));
        buttonC.setOnClickListener(v -> clickCharacter('c', buttonC, text));
        buttonD.setOnClickListener(v -> clickCharacter('d', buttonD, text));
        buttonE.setOnClickListener(v -> clickCharacter('e', buttonE, text));
        buttonF.setOnClickListener(v -> clickCharacter('f', buttonF, text));
        buttonG.setOnClickListener(v -> clickCharacter('g', buttonG, text));
        buttonH.setOnClickListener(v -> clickCharacter('h', buttonH, text));
        buttonI.setOnClickListener(v -> clickCharacter('i', buttonI, text));
        buttonJ.setOnClickListener(v -> clickCharacter('j', buttonJ, text));
        buttonK.setOnClickListener(v -> clickCharacter('k', buttonK, text));
        buttonL.setOnClickListener(v -> clickCharacter('l', buttonL, text));
        buttonM.setOnClickListener(v -> clickCharacter('m', buttonM, text));
        buttonN.setOnClickListener(v -> clickCharacter('n', buttonN, text));
        buttonO.setOnClickListener(v -> clickCharacter('o', buttonO, text));
        buttonP.setOnClickListener(v -> clickCharacter('p', buttonP, text));
        buttonQ.setOnClickListener(v -> clickCharacter('q', buttonQ, text));
        buttonR.setOnClickListener(v -> clickCharacter('r', buttonR, text));
        buttonS.setOnClickListener(v -> clickCharacter('s', buttonS, text));
        buttonT.setOnClickListener(v -> clickCharacter('t', buttonT, text));
        buttonU.setOnClickListener(v -> clickCharacter('u', buttonU, text));
        buttonV.setOnClickListener(v -> clickCharacter('v', buttonV, text));
        buttonW.setOnClickListener(v -> clickCharacter('w', buttonW, text));
        buttonX.setOnClickListener(v -> clickCharacter('x', buttonX, text));
        buttonY.setOnClickListener(v -> clickCharacter('y', buttonY, text));
        buttonZ.setOnClickListener(v -> clickCharacter('z', buttonZ, text));

    }


    private void clickCharacter(char c, Button b, TextView t) {
        Log.d("HANGMAN-onClick", "button" + c);
        hangman_.guessCharacter(c);
        t.setText(hangman_.getCurrentGuess());
        b.setEnabled(false);

        if(hangman_.isWordCorrect()) {
            ScoreHandler.getInstance().addPointsToScore(Hangman.HANGMAN_SCORE_INCREASE_PER_WIN);
            setField(false);
            showWin();
        }
        else {
            int wrong_guesses = hangman_.getNumberOfWrongGuesses();
            int MAX_GUESSES = 8;
            if(wrong_guesses >= MAX_GUESSES) {
                ScoreHandler.getInstance().addPointsToScore(Hangman.HANGMAN_SCORE_DECREASE_PER_LOSS);
                setField(false);
                showFail();
            }
            setImage(wrong_guesses);
        }
    }

    private void setImage(int wrong_guesses) {
        ImageView image_view = findViewById(R.id.imageView);


        switch (wrong_guesses) {
            case 1:
                image_view.setImageResource(R.drawable.hangman_01);
                break;
            case 2:
                image_view.setImageResource(R.drawable.hangman_02);
                break;
            case 3:
                image_view.setImageResource(R.drawable.hangman_03);
                break;
            case 4:
                image_view.setImageResource(R.drawable.hangman_04);
                break;
            case 5:
                image_view.setImageResource(R.drawable.hangman_05);
                break;
            case 6:
                image_view.setImageResource(R.drawable.hangman_06);
                break;
            case 7:
                image_view.setImageResource(R.drawable.hangman_07);
                break;
            case 8:
                image_view.setImageResource(R.drawable.hangman_08);
                break;
            default:
                image_view.setImageResource(R.drawable.hangman_00);

        }
    }

    private void setField(boolean b)
    {
        findViewById(R.id.buttonA).setEnabled(b);
        findViewById(R.id.buttonB).setEnabled(b);
        findViewById(R.id.buttonC).setEnabled(b);
        findViewById(R.id.buttonD).setEnabled(b);
        findViewById(R.id.buttonE).setEnabled(b);
        findViewById(R.id.buttonF).setEnabled(b);
        findViewById(R.id.buttonG).setEnabled(b);
        findViewById(R.id.buttonH).setEnabled(b);
        findViewById(R.id.buttonI).setEnabled(b);
        findViewById(R.id.buttonJ).setEnabled(b);
        findViewById(R.id.buttonK).setEnabled(b);
        findViewById(R.id.buttonL).setEnabled(b);
        findViewById(R.id.buttonM).setEnabled(b);
        findViewById(R.id.buttonN).setEnabled(b);
        findViewById(R.id.buttonO).setEnabled(b);
        findViewById(R.id.buttonP).setEnabled(b);
        findViewById(R.id.buttonQ).setEnabled(b);
        findViewById(R.id.buttonR).setEnabled(b);
        findViewById(R.id.buttonS).setEnabled(b);
        findViewById(R.id.buttonT).setEnabled(b);
        findViewById(R.id.buttonU).setEnabled(b);
        findViewById(R.id.buttonV).setEnabled(b);
        findViewById(R.id.buttonW).setEnabled(b);
        findViewById(R.id.buttonX).setEnabled(b);
        findViewById(R.id.buttonY).setEnabled(b);
        findViewById(R.id.buttonZ).setEnabled(b);
    }

    private void showFail() {
        final Button buttonHangmanPlayAgain = findViewById(R.id.buttonHangmanPlayAgain);
        buttonHangmanPlayAgain.setVisibility(View.VISIBLE);
        final TextView hangmanWinLoose = findViewById(R.id.hangmanWinLoose);
        hangmanWinLoose.setText(R.string.hangman_lost);
        hangmanWinLoose.setVisibility(View.VISIBLE);
    }

    private void showWin() {
        final Button buttonHangmanPlayAgain = findViewById(R.id.buttonHangmanPlayAgain);
        buttonHangmanPlayAgain.setVisibility(View.VISIBLE);
        final TextView hangmanWinLoose = findViewById(R.id.hangmanWinLoose);
        hangmanWinLoose.setText(R.string.hangman_win);
        hangmanWinLoose.setVisibility(View.VISIBLE);
    }

    private void Replay(TextView t, Button replayBtn, TextView gameSummary)
    {
        hangman_.reset();
        t.setText(hangman_.getCurrentGuess());
        replayBtn.setVisibility(View.INVISIBLE);
        gameSummary.setVisibility(View.INVISIBLE);
        setField(true);
        setImage(hangman_.getNumberOfWrongGuesses());
    }

}




