package com.example.calvinwang.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String first;
    public static String second;
    private TextView firstPlayerName;
    private TextView secondPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstPlayerName = findViewById(R.id.firstPlayerName);
        secondPlayerName = findViewById(R.id.secondPlayerName);
    }
    public void goToGame(View view) {
        Intent intent = new Intent(this, GamePage.class);
        intent.putExtra("first", first);
        intent.putExtra("second", second);
        first = firstPlayerName.getText().toString();
        second = secondPlayerName.getText().toString();
        startActivity(intent);
    }
}
