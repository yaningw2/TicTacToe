package com.example.calvinwang.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goToGame(View view) {
        TextView firstPlayerName = findViewById(R.id.firstPlayerName);
        TextView secondPlayerName = findViewById(R.id.secondPlayerName);
        String first = firstPlayerName.getText().toString();
        String second = secondPlayerName.getText().toString();
        Intent intent = new Intent(this, GamePage.class);
        intent.putExtra("first", first);
        intent.putExtra("second", second);
        startActivity(intent);
    }
}
