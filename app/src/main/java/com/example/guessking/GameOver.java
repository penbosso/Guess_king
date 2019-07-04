package com.example.guessking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    private TextView mScoreText;
    private Button mQuitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        mScoreText = findViewById(R.id.new_high_sc);
        mScoreText.setText(getString(R.string.new_high_sc) + " "+ Integer.toString(ClassicWorker.getScore()));

        // back / quit button
        final Intent quitIntent = new Intent(this, Menu.class);
        mQuitButton = findViewById(R.id.quitButton);
        mQuitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(quitIntent);
            }
        });

    }
}
