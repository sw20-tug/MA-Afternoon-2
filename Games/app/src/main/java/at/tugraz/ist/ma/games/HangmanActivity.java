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

public class HangmanActivity extends AppCompatActivity {

    final Hangman hangman = new Hangman(null, this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Context ctx = getApplication().getBaseContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        final TextView text = (TextView) findViewById(R.id.guessableWord);
        text.setText(hangman.getCurrentGuess());




        //1
        final Button buttonA = (Button) findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonA");
                hangman.guessCharacter('a');
                text.setText(hangman.getCurrentGuess());
                buttonA.setEnabled(false);
            }
        });

        //2
        final Button buttonB = (Button) findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonB");
                hangman.guessCharacter('b');
                text.setText(hangman.getCurrentGuess());
                buttonB.setEnabled(false);
            }
        });

        //3
        final Button buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonC");
                hangman.guessCharacter('c');
                text.setText(hangman.getCurrentGuess());
                buttonC.setEnabled(false);
            }
        });

        //4
        final Button buttonD = (Button) findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonD");
                hangman.guessCharacter('d');
                text.setText(hangman.getCurrentGuess());
                buttonD.setEnabled(false);
            }
        });


        //5
        final Button buttonE = (Button) findViewById(R.id.buttonE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonE");
                hangman.guessCharacter('e');
                text.setText(hangman.getCurrentGuess());
                buttonE.setEnabled(false);
            }
        });

        //6
        final Button buttonF = (Button) findViewById(R.id.buttonF);
        buttonF.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonF");
                hangman.guessCharacter('f');
                text.setText(hangman.getCurrentGuess());
                buttonF.setEnabled(false);
            }
        });


        //7
        final Button buttonG = (Button) findViewById(R.id.buttonG);
        buttonG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonG");
                hangman.guessCharacter('g');
                text.setText(hangman.getCurrentGuess());
                buttonG.setEnabled(false);
            }
        });

        //8
        final Button buttonH = (Button) findViewById(R.id.buttonH);
        buttonH.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonH");
                hangman.guessCharacter('h');
                text.setText(hangman.getCurrentGuess());
                buttonH.setEnabled(false);
            }
        });

        //9
        final Button buttonI = (Button) findViewById(R.id.buttonI);
        buttonI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonI");
                hangman.guessCharacter('i');
                text.setText(hangman.getCurrentGuess());
                buttonI.setEnabled(false);
            }
        });

        //10
        final Button buttonJ = (Button) findViewById(R.id.buttonJ);
        buttonJ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonJ");
                hangman.guessCharacter('j');
                text.setText(hangman.getCurrentGuess());
                buttonJ.setEnabled(false);
            }
        });


        //11
        final Button buttonK = (Button) findViewById(R.id.buttonK);
        buttonK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonK");
                hangman.guessCharacter('k');
                text.setText(hangman.getCurrentGuess());
                buttonK.setEnabled(false);
            }
        });

        //12
        final Button buttonL = (Button) findViewById(R.id.buttonL);
        buttonL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonL");
                hangman.guessCharacter('l');
                text.setText(hangman.getCurrentGuess());
                buttonL.setEnabled(false);
            }
        });

        //13
        final Button buttonM = (Button) findViewById(R.id.buttonM);
        buttonM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonM");
                hangman.guessCharacter('m');
                text.setText(hangman.getCurrentGuess());
                buttonM.setEnabled(false);
            }
        });

        //14
        final Button buttonN = (Button) findViewById(R.id.buttonN);
        buttonN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonN");
                hangman.guessCharacter('n');
                text.setText(hangman.getCurrentGuess());
                buttonN.setEnabled(false);
            }
        });

        //15
        final Button buttonO = (Button) findViewById(R.id.buttonO);
        buttonO.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonO");
                hangman.guessCharacter('o');
                text.setText(hangman.getCurrentGuess());
                buttonO.setEnabled(false);
            }
        });

        //16
        final Button buttonP = (Button) findViewById(R.id.buttonP);
        buttonP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonP");
                hangman.guessCharacter('p');
                text.setText(hangman.getCurrentGuess());
                buttonP.setEnabled(false);
            }
        });


        //17
        final Button buttonQ = (Button) findViewById(R.id.buttonQ);
        buttonQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonQ");
                hangman.guessCharacter('q');
                text.setText(hangman.getCurrentGuess());
                buttonQ.setEnabled(false);
            }
        });

        //18
        final Button buttonR = (Button) findViewById(R.id.buttonR);
        buttonR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonR");
                hangman.guessCharacter('r');
                text.setText(hangman.getCurrentGuess());
                buttonR.setEnabled(false);
            }
        });


        //19
        final Button buttonS = (Button) findViewById(R.id.buttonS);
        buttonS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonS");
                hangman.guessCharacter('s');
                text.setText(hangman.getCurrentGuess());
                buttonS.setEnabled(false);
            }
        });

        //20
        final Button buttonT = (Button) findViewById(R.id.buttonT);
        buttonT.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonT");
                hangman.guessCharacter('t');
                text.setText(hangman.getCurrentGuess());
                buttonT.setEnabled(false);
            }
        });

        //21
        final Button buttonU = (Button) findViewById(R.id.buttonU);
        buttonU.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonU");
                hangman.guessCharacter('u');
                text.setText(hangman.getCurrentGuess());
                buttonU.setEnabled(false);
            }
        });

        //22
        final Button buttonV = (Button) findViewById(R.id.buttonV);
        buttonV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonV");
                hangman.guessCharacter('v');
                text.setText(hangman.getCurrentGuess());
                buttonV.setEnabled(false);
            }
        });


        //23
        final Button buttonW = (Button) findViewById(R.id.buttonW);
        buttonW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonW");
                hangman.guessCharacter('w');
                text.setText(hangman.getCurrentGuess());
                buttonW.setEnabled(false);
            }
        });

        //24
        final Button buttonX = (Button) findViewById(R.id.buttonX);
        buttonX.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonX");
                hangman.guessCharacter('x');
                text.setText(hangman.getCurrentGuess());
                buttonX.setEnabled(false);
            }
        });

        //25
        final Button buttonY = (Button) findViewById(R.id.buttonY);
        buttonY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonY");
                hangman.guessCharacter('y');
                text.setText(hangman.getCurrentGuess());
                buttonY.setEnabled(false);
            }
        });

        //26
        final Button buttonZ = (Button) findViewById(R.id.buttonZ);
        buttonZ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                Log.e("HANGMAN-onClick", "buttonZ");
                hangman.guessCharacter('z');
                text.setText(hangman.getCurrentGuess());
                buttonZ.setEnabled(false);
            }
        });







    }







}




