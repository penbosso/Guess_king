package com.example.guessking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Classic extends AppCompatActivity {

    private TextView mRoundText, mScoreText, mGuessKingText, mGuessBotText, mRoundToLiveText;
    private Button mFirstNumberButton;
    private Button mSecondNumberButton;
    private Button mThirdNumberButton;
    private Button mFourthNumberButton;
    private ImageView mPlay;

    //selection handling variables
    int countSelection = 0, FirstButtonSelected = 0, SecondButtonSelected = 0, ThirdButtonSelected = 0, FourthButtonSelected = 0;
    int firstChoice, secondChoice, thirdChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);

        mPlay = findViewById(R.id.play);

        mRoundText = findViewById(R.id.roundText);
        mScoreText = findViewById(R.id.scoreText);
        mRoundToLiveText = findViewById(R.id.roundToLiveText);

        mGuessKingText = findViewById(R.id.guessKingNumber);
        mGuessBotText = findViewById(R.id.guessbot_textView);

        Button mQuitButton = findViewById(R.id.quitButton);
        mFirstNumberButton = findViewById(R.id.first_button);
        mSecondNumberButton = findViewById(R.id.second_button);
        mThirdNumberButton = findViewById(R.id.third_button);
        mFourthNumberButton = findViewById(R.id.fourth_button);

        // Play Relay
        mPlay.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                mPlay.setVisibility(View.GONE);
            }

        });

        recurcivePlay();

        // back / quit button
        final Intent quitIntent = new Intent(this, Menu.class);
        mQuitButton = findViewById(R.id.quitButton);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(quitIntent);
            }
        });

        //TODO: handle number selection, reset selection, evaluate guess

    }

    private void recurcivePlay() {
        displayView();

        if (ClassicWorker.getTimeToLive() > 0){
            //Handling selections or choices
            mFirstNumberButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    if(FirstButtonSelected == 0) {
                        FirstButtonSelected = 1;
                        countSelection += 1;

                        if(countSelection == 1){
                            mFirstNumberButton.setBackgroundResource(R.drawable.green_text_view_circle);
                            firstChoice = ClassicWorker.getFirstNumber();
                        }
                        else if (countSelection == 2) {
                            mFirstNumberButton.setBackgroundResource(R.drawable.yellow_text_view_circle);
                            secondChoice = ClassicWorker.getFirstNumber();
                        }
                        else if (countSelection == 3) {
                            mFirstNumberButton.setBackgroundResource(R.drawable.orange_text_view_circle);
                            thirdChoice = ClassicWorker.getFirstNumber();
                            //display guessking's number and evaluate
                            displayKingNumber();

                            // Reset the selection and continue game
                            resetRecursive();
                        }

                    }
                    else {
                        resetSelection();
                    }
                }
            });

            mSecondNumberButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    if(SecondButtonSelected == 0) {
                        SecondButtonSelected = 1;
                        countSelection += 1;

                        if(countSelection == 1){
                            mSecondNumberButton.setBackgroundResource(R.drawable.green_text_view_circle);
                            firstChoice = ClassicWorker.getSecondNumber();
                        }
                        else if (countSelection == 2) {
                            mSecondNumberButton.setBackgroundResource(R.drawable.yellow_text_view_circle);
                            secondChoice = ClassicWorker.getSecondNumber();
                        }
                        else if (countSelection == 3) {
                            mSecondNumberButton.setBackgroundResource(R.drawable.orange_text_view_circle);
                            thirdChoice = ClassicWorker.getSecondNumber();
                            //display guessking's number and evaluate
                            displayKingNumber();

                            // Reset the selection and continue game
                            resetRecursive();
                        }

                    }
                    else {
                        resetSelection();
                    }
                }
            });

            mThirdNumberButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    if(ThirdButtonSelected == 0) {
                        ThirdButtonSelected = 1;
                        countSelection += 1;

                        if(countSelection == 1){
                            mThirdNumberButton.setBackgroundResource(R.drawable.green_text_view_circle);
                            firstChoice = ClassicWorker.getThirdNumber();
                        }
                        else if (countSelection == 2) {
                            mThirdNumberButton.setBackgroundResource(R.drawable.yellow_text_view_circle);
                            secondChoice = ClassicWorker.getThirdNumber();
                        }
                        else if (countSelection == 3) {
                            mThirdNumberButton.setBackgroundResource(R.drawable.orange_text_view_circle);
                            thirdChoice = ClassicWorker.getThirdNumber();
                            //display guessking's number and evaluate
                            displayKingNumber();

                            // Reset the selection and continue game
                            resetRecursive();
                        }

                    }
                    else {
                        resetSelection();
                    }
                }
            });

            mFourthNumberButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {
                    if(FourthButtonSelected == 0) {
                        FourthButtonSelected = 1;
                        countSelection += 1;

                        if(countSelection == 1){
                            mFourthNumberButton.setBackgroundResource(R.drawable.green_text_view_circle);
                            firstChoice = ClassicWorker.getFourthNumber();
                        }
                        else if (countSelection == 2) {
                            mFourthNumberButton.setBackgroundResource(R.drawable.yellow_text_view_circle);
                            secondChoice = ClassicWorker.getFourthNumber();
                        }
                        else if (countSelection == 3) {
                            mFourthNumberButton.setBackgroundResource(R.drawable.orange_text_view_circle);
                            thirdChoice = ClassicWorker.getFourthNumber();
                            //display guessking's number and evaluate
                            displayKingNumber();

                            // Reset the selection and continue game
                            resetRecursive();

                        }

                    }
                    else {
                        resetSelection();
                    }
                }
            });
        }
        else {
            //Game Over
            Intent gameOverIntent = new Intent(this, GameOver.class);
            startActivity(gameOverIntent);
        }
    }

    private void resetRecursive() {
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                resetSelection();
                recurcivePlay();
            }
        }.start();
    }

    @SuppressLint("SetTextI18n")
    private void displayView() {
        ClassicWorker.generateNumbers();
        mFirstNumberButton.setText(Integer.toString(ClassicWorker.getFirstNumber()));
        mSecondNumberButton.setText(Integer.toString(ClassicWorker.getSecondNumber()));
        mThirdNumberButton.setText(Integer.toString(ClassicWorker.getThirdNumber()));
        mFourthNumberButton.setText(Integer.toString(ClassicWorker.getFourthNumber()));
        mGuessBotText.setText("GuessBot Predict: " + Integer.toString(ClassicWorker.getGuessBotNumber()));
        //set score and round
        mRoundText.setText(Integer.toString(ClassicWorker.getRound()));
        mScoreText.setText(Integer.toString(ClassicWorker.getScore()));
        mRoundToLiveText.setText(Integer.toString(ClassicWorker.getTimeToLive()));

        mGuessKingText.setText("?");
    }

    @SuppressLint("SetTextI18n")
    private void displayKingNumber() {
        mGuessKingText.setText(Integer.toString(ClassicWorker.getGuessKingNumber()));
        mGuessKingText.setBackgroundResource(R.drawable.blue_text_view_circle);
        ClassicWorker.evaluateGuess(firstChoice, secondChoice, thirdChoice);

        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { }
            public void onFinish() {
                mGuessKingText.setBackgroundResource(R.drawable.text_view_circle);
            }
        }.start();

    }

    private void resetSelection() {
        FirstButtonSelected = 0;
        SecondButtonSelected = 0;
        ThirdButtonSelected = 0;
        FourthButtonSelected = 0;
        countSelection = 0;

        mFirstNumberButton.setBackgroundResource(R.drawable.text_view_circle);
        mSecondNumberButton.setBackgroundResource(R.drawable.text_view_circle);
        mThirdNumberButton.setBackgroundResource(R.drawable.text_view_circle);
        mFourthNumberButton.setBackgroundResource(R.drawable.text_view_circle);
    }

}
