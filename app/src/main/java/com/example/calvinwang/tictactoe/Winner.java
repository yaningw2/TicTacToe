package com.example.calvinwang.tictactoe;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class Winner extends AppCompatActivity {

    private String message;
    private TextToSpeech mTTs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        String winner = getIntent().getStringExtra("winner");
        TextView winnerName = findViewById(R.id.winnerName);
        message = winner.toUpperCase() + " WINS!!!";
        winnerName.setText(message);
    }

    public void goToGame(View view) {
        Intent intent = new Intent(this, GamePage.class);
        startActivity(intent);
    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
