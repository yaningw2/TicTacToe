package com.example.calvinwang.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        String winner = getIntent().getStringExtra("winner");
        TextView winnerName = findViewById(R.id.winnerName);
        String message = winner.toUpperCase() + " WINS!!!";
        winnerName.setText(message);
    }
}
