package com.example.guessking;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Classic extends AppCompatActivity {

    private TextView mRoundText, mScoreText, mGuessKingText, mGuessBotText;
    private Button mQuitButton, mFirstNumberButton, mSecondNumberButton, mThirdNumberButton, mFourthNuberButton;
    private ImageView mPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        mPlay = (ImageView) findViewById(R.id.play);

        mRoundText = (TextView) findViewById(R.id.roundText);
        mScoreText = (TextView) findViewById(R.id.scoreText);

        mGuessKingText = (TextView) findViewById(R.id.guessKingNumber);
        mGuessBotText = (TextView) findViewById(R.id.guessbot_textView);

        mQuitButton = (Button) findViewById(R.id.quitButton);
        mFirstNumberButton = (Button) findViewById(R.id.first_button);
        mSecondNumberButton = (Button) findViewById(R.id.second_button);
        mThirdNumberButton = (Button) findViewById(R.id.third_button);
        mFourthNuberButton = (Button) findViewById(R.id.fourth_button);


        mPlay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                displayView();

            }

            private void displayView() {
                mPlay.setVisibility(View.INVISIBLE);
                ClassicWorker.generateNumbers();
                mFirstNumberButton.setText(Integer.toString(ClassicWorker.getFirstNumber()));
                mSecondNumberButton.setText(Integer.toString(ClassicWorker.getSecondNumber()));
                mThirdNumberButton.setText(Integer.toString(ClassicWorker.getThirdNumber()));
                mFourthNuberButton.setText(Integer.toString(ClassicWorker.getFourthNumber()));
                mGuessBotText.setText("GuessBot Predict: " + Integer.toString(ClassicWorker.getGuessBotNumber()));

                new CountDownTimer(30000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    public void onFinish() {
                        mGuessKingText.setText(Integer.toString(ClassicWorker.getGuessKingNumber()));
                    }
                }.start();
            }
        });
       //TODO: handle number selection

    }

}
