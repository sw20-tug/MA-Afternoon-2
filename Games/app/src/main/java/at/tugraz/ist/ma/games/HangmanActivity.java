package at.tugraz.ist.ma.games;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class HangmanActivity extends AppCompatActivity {
    // DEFINES
    public final int MAX_GUESSES = 8;
    // --

    final Hangman hangman = new Hangman(null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Context ctx = getApplication().getBaseContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        final TextView text = (TextView) findViewById(R.id.guessableWord);
        text.setText(hangman.getCurrentGuess());

        final Button buttonHangmanPlayAgain = (Button) findViewById(R.id.buttonHangmanPlayAgain);
        final TextView hangmanWinLoose = (TextView) findViewById(R.id.hangmanWinLoose);
        buttonHangmanPlayAgain.setOnClickListener(v -> Replay(text,buttonHangmanPlayAgain,hangmanWinLoose));



        final Button buttonA = (Button) findViewById(R.id.buttonA);
        final Button buttonB = (Button) findViewById(R.id.buttonB);
        final Button buttonC = (Button) findViewById(R.id.buttonC);
        final Button buttonD = (Button) findViewById(R.id.buttonD);
        final Button buttonE = (Button) findViewById(R.id.buttonE);
        final Button buttonF = (Button) findViewById(R.id.buttonF);
        final Button buttonG = (Button) findViewById(R.id.buttonG);
        final Button buttonH = (Button) findViewById(R.id.buttonH);
        final Button buttonI = (Button) findViewById(R.id.buttonI);
        final Button buttonJ = (Button) findViewById(R.id.buttonJ);
        final Button buttonK = (Button) findViewById(R.id.buttonK);
        final Button buttonL = (Button) findViewById(R.id.buttonL);
        final Button buttonM = (Button) findViewById(R.id.buttonM);
        final Button buttonN = (Button) findViewById(R.id.buttonN);
        final Button buttonO = (Button) findViewById(R.id.buttonO);
        final Button buttonP = (Button) findViewById(R.id.buttonP);
        final Button buttonQ = (Button) findViewById(R.id.buttonQ);
        final Button buttonR = (Button) findViewById(R.id.buttonR);
        final Button buttonS = (Button) findViewById(R.id.buttonS);
        final Button buttonT = (Button) findViewById(R.id.buttonT);
        final Button buttonU = (Button) findViewById(R.id.buttonU);
        final Button buttonV = (Button) findViewById(R.id.buttonV);
        final Button buttonW = (Button) findViewById(R.id.buttonW);
        final Button buttonX = (Button) findViewById(R.id.buttonX);
        final Button buttonY = (Button) findViewById(R.id.buttonY);
        final Button buttonZ = (Button) findViewById(R.id.buttonZ);

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
        Log.e("HANGMAN-onClick", "button" + c);
        hangman.guessCharacter(c);
        t.setText(hangman.getCurrentGuess());
        b.setEnabled(false);

        if(hangman.isWordCorrect()) {
            setField(false);
            showWin();
        }
        else {
            int wrong_guesses = hangman.getNumberOfWrongGuesses();
            if(wrong_guesses >= MAX_GUESSES) {
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
        ((Button) findViewById(R.id.buttonA)).setEnabled(b);
        ((Button) findViewById(R.id.buttonB)).setEnabled(b);
        ((Button) findViewById(R.id.buttonC)).setEnabled(b);
        ((Button) findViewById(R.id.buttonD)).setEnabled(b);
        ((Button) findViewById(R.id.buttonE)).setEnabled(b);
        ((Button) findViewById(R.id.buttonF)).setEnabled(b);
        ((Button) findViewById(R.id.buttonG)).setEnabled(b);
        ((Button) findViewById(R.id.buttonH)).setEnabled(b);
        ((Button) findViewById(R.id.buttonI)).setEnabled(b);
        ((Button) findViewById(R.id.buttonJ)).setEnabled(b);
        ((Button) findViewById(R.id.buttonK)).setEnabled(b);
        ((Button) findViewById(R.id.buttonL)).setEnabled(b);
        ((Button) findViewById(R.id.buttonM)).setEnabled(b);
        ((Button) findViewById(R.id.buttonN)).setEnabled(b);
        ((Button) findViewById(R.id.buttonO)).setEnabled(b);
        ((Button) findViewById(R.id.buttonP)).setEnabled(b);
        ((Button) findViewById(R.id.buttonQ)).setEnabled(b);
        ((Button) findViewById(R.id.buttonR)).setEnabled(b);
        ((Button) findViewById(R.id.buttonS)).setEnabled(b);
        ((Button) findViewById(R.id.buttonT)).setEnabled(b);
        ((Button) findViewById(R.id.buttonU)).setEnabled(b);
        ((Button) findViewById(R.id.buttonV)).setEnabled(b);
        ((Button) findViewById(R.id.buttonW)).setEnabled(b);
        ((Button) findViewById(R.id.buttonX)).setEnabled(b);
        ((Button) findViewById(R.id.buttonY)).setEnabled(b);
        ((Button) findViewById(R.id.buttonZ)).setEnabled(b);
    }

    private void showFail() {
        final Button buttonHangmanPlayAgain = (Button) findViewById(R.id.buttonHangmanPlayAgain);
        buttonHangmanPlayAgain.setVisibility(View.VISIBLE);
        final TextView hangmanWinLoose = (TextView) findViewById(R.id.hangmanWinLoose);
        hangmanWinLoose.setText(R.string.hangman_lost);
        hangmanWinLoose.setVisibility(View.VISIBLE);
    }

    private void showWin() {
        final Button buttonHangmanPlayAgain = (Button) findViewById(R.id.buttonHangmanPlayAgain);
        buttonHangmanPlayAgain.setVisibility(View.VISIBLE);
        final TextView hangmanWinLoose = (TextView) findViewById(R.id.hangmanWinLoose);
        hangmanWinLoose.setText(R.string.hangman_win);
        hangmanWinLoose.setVisibility(View.VISIBLE);
    }

    private void Replay(TextView t, Button replayBtn, TextView gameSummary)
    {
        hangman.reset();
        t.setText(hangman.getCurrentGuess());
        replayBtn.setVisibility(View.INVISIBLE);
        gameSummary.setVisibility(View.INVISIBLE);
        setField(true);
        setImage(hangman.getNumberOfWrongGuesses());
    }

}




