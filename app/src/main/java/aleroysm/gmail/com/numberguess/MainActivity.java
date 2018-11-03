package aleroysm.gmail.com.numberguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            // fields
            TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);

            // generate random number (1,100) and welcome message
            final int randomNum = (int) (Math.random() * 100) + 1;
            welcomeTextView.setText("Hey! You have 5 guesses to find the hidden number. Good luck!");


            // loop with 5 tries
            for (int i = 5; i > 0; i--) {

                Button goBtn = (Button) findViewById(R.id.goBtn);
                goBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        EditText guessEditText = (EditText) findViewById(R.id.guessEditText);
                        int guess = Integer.parseInt(guessEditText.getText().toString());
                        String message = "";
                        int i = 5;


                        if (randomNum > guess) {
                            message = "So close! The number is above " + guess + ". You have " + --i + " guess(es) left.";
                        } else if (randomNum < guess) {
                            message = "So close! The number is below " + guess + ". You have " + --i + " guess(es) left.";
                        } else if (randomNum == guess) {
                            message = "Congrats!!! You won. The hidden number is " + randomNum;
                        }
                        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                        resultTextView.setText(message);

                }});
            }


            TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
            if (resultTextView.getText().equals("Congrats!!! You won. The hidden number is " + randomNum) == false &&
                resultTextView.getText().equals("") == false)  {
                String message = "GAME OVER. YOU LOSE! THE NUMBER WAS " + randomNum;
                resultTextView.setText(message);
            }


    }
}


            /* PROBLEM WITH THE LOOP: it does not work.   HOW TO SHOW THE NUMBER OF GUESSES LEFT?    HOW TO LIMIT THE GUESSES TO 5?  */

