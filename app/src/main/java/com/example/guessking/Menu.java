package com.example.guessking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Button mClassicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mClassicButton = findViewById(R.id.classicButton);

        final Intent classicIntent = new Intent(this, Classic.class);
        mClassicButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(classicIntent);
            }
        });
    }
}
