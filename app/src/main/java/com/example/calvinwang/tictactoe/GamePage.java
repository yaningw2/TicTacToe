package com.example.calvinwang.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

public class GamePage extends AppCompatActivity {
    /**
     * this is my game board. It is a boolean 2D array.
     * false means this spot has not been occupied.
     * yes means that this spot is already occupied.
     * Attempts to play on any occupied spots should trigger error message to show"I don't know?".
     */
    public static int[][] board;

    private ImageButton button01;
    private ImageButton button02;
    private ImageButton button00;
    private ImageButton button11;
    private ImageButton button12;
    private ImageButton button10;
    private ImageButton button20;
    private ImageButton button21;
    private ImageButton button22;

    private String firstName;
    private String secondName;
    /**
     * this function makes the move.
     * it should check whether this spot is already occupied.
     * if occupied, show error message. return false;
     * if not occupied, make the spot on the board true. return true
     * finally check if the game is won.
     * @param x x coordinate (row)
     * @param y y coordinate (column)
     * @return true if this move is successful.
     */
    private boolean makeAMove(int x, int y) {
        if (board[x][y] != 0) {
            // show the error message.
            return false;
        } else {
            board[x][y] = whoseMove();
            checkWin();
            return true;
        }
    }

    // the cluster of functions to makeAMove, called when the imagebutton is pressed.
    public void play00(View view) {
        if (makeAMove(0, 0)) {
            if (board[0][0] == 1) {
                button00.setImageResource(R.color.blue);
            } else {
                button00.setImageResource(R.color.orange);
            }
        }
    }
    public void play01(View view) {
        if (makeAMove(0, 1)) {
            if (board[0][1] == 1) {
                button01.setImageResource(R.color.blue);
            } else {
                button01.setImageResource(R.color.orange);
            }
        }
    }
    public void play02(View view) {
        if (makeAMove(0, 2)) {
            if (board[0][2] == 1) {
                button02.setImageResource(R.color.blue);
            } else {
                button02.setImageResource(R.color.orange);
            }
        }
    }
    public void play10(View view) {
        if (makeAMove(1, 0)) {
            if (board[1][0] == 1) {
                button10.setImageResource(R.color.blue);
            } else {
                button10.setImageResource(R.color.orange);
            }
        }
    }
    public void play11(View view) {
        if (makeAMove(1, 1)) {
            if (board[1][1] == 1) {
                button11.setImageResource(R.color.blue);
            } else {
                button11.setImageResource(R.color.orange);
            }
        }
    }
    public void play12(View view) {
        if (makeAMove(1, 2)) {
            if (board[1][2] == 1) {
                button12.setImageResource(R.color.blue);
            } else {
                button12.setImageResource(R.color.orange);
            }
        }
    }
    public void play20(View view) {
        if (makeAMove(2, 0)) {
            if (board[2][0] == 1) {
                button20.setImageResource(R.color.blue);
            } else {
                button20.setImageResource(R.color.orange);
            }
        }
    }
    public void play21(View view) {
        if (makeAMove(2, 1)) {
            if (board[2][1] == 1) {
                button21.setImageResource(R.color.blue);
            } else {
                button21.setImageResource(R.color.orange);
            }
        }
    }
    public void play22(View view) {
        if (makeAMove(2, 2)) {
            if (board[2][2] == 1) {
                button22.setImageResource(R.color.blue);
            } else {
                button22.setImageResource(R.color.orange);
            }
        }
    }


    /**
     * set up all the spots to be false "unoccupied".
     * @param board
     */
    private static void setUpBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * use a static int to represent which player is supposed to play now.
     * in case of undo, just call whoseMove() again.
     */
    private  static int whoseTurn;

    /**
     * change int whoseTurn from 1 to 2, or the other way around.
     * @return which player is supposed to play now
     */
    private static int whoseMove() {
        if (whoseTurn == 1) {
            whoseTurn = 2;
            return 1;
        } else {
            whoseTurn = 1;
            return 2;
        }
    }


    private static int firstMove() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return 1;
            // display which player makes the first move.
        } else {
            return 2;
        }
    }

    private void checkWin() {
        Intent intent = new Intent(this, Winner.class);
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != 0) {
                if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                    if (board[i][0] == 1) {
                        intent.putExtra("winner", firstName);
                    } else {
                        intent.putExtra("winner", secondName);
                    }
                    startActivity(intent);
                }
            }
            if (board[0][i] != 0) {
                if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                    if (board[i][0] == 1) {
                        intent.putExtra("winner", firstName);
                    } else {
                        intent.putExtra("winner", secondName);
                    }
                    startActivity(intent);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        //initialise all the buttons
        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        firstName = getIntent().getStringExtra("first");
        secondName = getIntent().getStringExtra("second");
        //initialise my board here. and also set it up.
        board = new int[3][3];
        setUpBoard(board);
        //let function firstMove() decide who plays first by changing int whoseTurn.
        whoseTurn = firstMove();
    }
}
